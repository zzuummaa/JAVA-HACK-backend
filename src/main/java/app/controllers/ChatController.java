package app.controllers;

import app.entities.MessageDB;
import app.models.Message;
import app.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/chatBot")
public class ChatController {
    @Autowired
    MessagesRepository messagesRepository;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Message>> getAll() {
        List<Message> messages = StreamSupport.stream(
                messagesRepository.findAllByOrderByDateAsc().spliterator(), false)
                .map(Message::new).collect(Collectors.toList());
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody Message message) {
        MessageDB messageDb = new MessageDB(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
