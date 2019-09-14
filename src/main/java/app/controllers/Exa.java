package app.controllers;

//import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exa {

   /* @Autowired
    private UserRepository userRepository;*/

    @GetMapping("/")
    public ResponseEntity<?> example(){
        return new ResponseEntity<String>("Hello world",HttpStatus.OK);
    }
}
