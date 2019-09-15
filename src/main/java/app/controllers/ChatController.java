package app.controllers;

import app.TextSimilarityCalculator;
import app.entities.BuisnessDescriptionDB;
import app.entities.MessageDB;
import app.models.BuisnessDescription;
import app.models.Message;
import app.repository.BuisnessDescriptionRepository;
import app.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/chatbot")
public class ChatController {
    private final MessagesRepository messagesRepository;
    private final BuisnessDescriptionRepository buisnessDescriptionRepository;

    private int queueCapacity = 2;
    private AtomicInteger queueSize = new AtomicInteger();
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public ChatController(BuisnessDescriptionRepository buisnessDescriptionRepository, MessagesRepository messagesRepository) {
        this.buisnessDescriptionRepository = buisnessDescriptionRepository;
        this.messagesRepository = messagesRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Message>> getAll() {
        List<Message> messages = StreamSupport.stream(
                messagesRepository.findAllByOrderByDateAsc().spliterator(), false)
                .map(Message::new).collect(Collectors.toList());
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Message message) {
        String question = message.getBody();
        if (question == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (queueSize.getAndIncrement() < queueCapacity) {
            executor.submit(() -> {
                long start = System.currentTimeMillis();
                try {
                    List<BuisnessDescriptionDB> bd = StreamSupport.stream(
                            buisnessDescriptionRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());

                    String[] descriptions = bd.stream()
                            .map((it) -> it.getDescriptionText() + " " + it.getName() + " " + it.getCategory())
                            .toArray(String[]::new);
                    int answerId = TextSimilarityCalculator.answer(question, descriptions);
                    String answerStr;
                    if (answerId == -1) {
                        answerStr = "Не понял команду";
                    } else {
                        answerStr = "ref://" + bd.get(answerId).getId();
                    }
                    MessageDB messageDB = MessageDB.builder()
                            .date(LocalDateTime.now().plusSeconds(1))
                            .isBot(true)
                            .body(answerStr)
                            .build();
                    messagesRepository.save(messageDB);
                    queueSize.decrementAndGet();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                long end = System.currentTimeMillis();
                System.out.println("answer calc time: " + (end - start));
            });
        }

        messagesRepository.save(new MessageDB(message));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
