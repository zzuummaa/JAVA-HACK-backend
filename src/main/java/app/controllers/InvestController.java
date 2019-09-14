package app.controllers;

import app.models.BuisnessDescription;
import app.models.BuisnessDescriptionDB;
import app.repository.BuisnessDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/investments")
public class InvestController {

    @Autowired
    private BuisnessDescriptionRepository buisnessDescriptionRepository;

    @GetMapping("/businesses")
    public ResponseEntity<?> example(@RequestParam(required = false) String category) {
        if (category == null) {
            List<BuisnessDescription> bd = StreamSupport.stream(
                    buisnessDescriptionRepository.findAll().spliterator(), false)
                    .map(BuisnessDescription::new).collect(Collectors.toList());

            return new ResponseEntity<>(bd, HttpStatus.OK);
        } else {
            try {
                Category.valueOf(category);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<BuisnessDescription> bd = StreamSupport.stream(
                    buisnessDescriptionRepository.getByCategory(category).spliterator(), false)
                    .map(BuisnessDescription::new).collect(Collectors.toList());

            return new ResponseEntity<>(bd, HttpStatus.OK);
        }
    }

    @PostMapping("businesses")
    public ResponseEntity<?> add(@RequestBody BuisnessDescription buisnessDescription) {
        buisnessDescriptionRepository.save(new BuisnessDescriptionDB(buisnessDescription));
        return new ResponseEntity<>(buisnessDescription, HttpStatus.OK);
    }
}
