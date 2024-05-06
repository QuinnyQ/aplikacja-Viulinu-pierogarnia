package com.pierogarnia.viulinu.controller;

import com.pierogarnia.viulinu.model.user.Person;
import com.pierogarnia.viulinu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registerpost")
public class RegisterController {
    private final PersonRepository personRepository;

    @Autowired
    public RegisterController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @PostMapping
    private String addUser(Person person){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(person.getPassword());
        person.setPassword(encryptedPassword);
        personRepository.save(person);
        return "login";
    }

}
