package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.entity.User;
import recipes.repository.UserRepository;

import javax.validation.Valid;

@RestController
public class UserRegistrationController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepo;

    // Endpoint: Update a recipe in the database
    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

        if (!userRepo.existsByEmail(user.getEmail())) {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
            return new ResponseEntity<>("Registered successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User is already registered", HttpStatus.BAD_REQUEST);
        }
    }
}