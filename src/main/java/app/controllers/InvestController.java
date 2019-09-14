package app.controllers;

//import app.repository.UserRepository;

import app.models.BuisnessDescription;
import app.repository.BuisnessDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
public class InvestController {

    @Autowired
    private BuisnessDescriptionRepository buisnessDescriptionRepository;

    @GetMapping("/businesses")
    public ResponseEntity<?> example(@RequestParam(required = false) String category) {
        BuisnessDescription buisnessDescription;
        if (category == null) {
            return new ResponseEntity<>(buisnessDescriptionRepository.findAll(), HttpStatus.OK);
        } else {
            try {
                Category.valueOf(category);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            buisnessDescriptionRepository.getByCategory(category);
            return new ResponseEntity<>(buisnessDescriptionRepository.getByCategory(category), HttpStatus.OK);
        }
    }


    @GetMapping("/add/businesses")
    public ResponseEntity<?> add() {
        BuisnessDescription buisnessDescription;
        buisnessDescription = BuisnessDescription.builder()
                .name("Miscrosoft")
                .category("IT")
                .iconURL("http://zzuummaa.sytes.net:8070/fileserver/investment/microsoft.png")
                .build();
        buisnessDescriptionRepository.save(buisnessDescription);
        return new ResponseEntity<BuisnessDescription>(buisnessDescription, HttpStatus.OK);
    }
}
