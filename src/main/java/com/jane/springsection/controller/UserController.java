package com.jane.springsection.controller;

import com.jane.springsection.model.Customer;
import com.jane.springsection.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final CompromisedPasswordChecker checker;

    public void validatePassword(String password){
        CompromisedPasswordDecision decision = checker.check(password);
        if (decision.isCompromised()) {
            throw new IllegalArgumentException(
                    "Password has been compromised in a data breach"
            );
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        try {
            Customer newCustomer = new Customer();
            newCustomer.setEmail(customer.getEmail());
            validatePassword(customer.getPwd());
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            newCustomer.setPwd(hashedPwd);
            newCustomer.setRole(customer.getRole());

            customerRepository.save(newCustomer);

            if(newCustomer.getId() > 0){
                return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
            }
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred "+ex.getMessage());
        }


    }
}
