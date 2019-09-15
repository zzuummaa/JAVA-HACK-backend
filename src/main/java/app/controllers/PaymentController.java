package app.controllers;

import app.entities.PaymentDB;
import app.models.BuisnessDescription;
import app.models.Payment;
import app.repository.PaymentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/investments/payments")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Payment payment) {
        PaymentDB paymentDB = paymentRepository.save(new PaymentDB(payment));
        return new ResponseEntity<>(new Payment(paymentDB), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Payment> payments = StreamSupport.stream(
                paymentRepository.findAll().spliterator(), false)
                .map(Payment::new).collect(Collectors.toList());
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        paymentRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
