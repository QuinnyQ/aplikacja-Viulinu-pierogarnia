package com.pierogarnia.viulinu.service;

import com.pierogarnia.viulinu.model.user.SecurityPerson;
import com.pierogarnia.viulinu.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public JpaUserDetailsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return personRepository
                .findByUsername(username)
                .map(SecurityPerson::new)
                .orElseThrow(()->new UsernameNotFoundException("Email not found: " + username));
    }
}
