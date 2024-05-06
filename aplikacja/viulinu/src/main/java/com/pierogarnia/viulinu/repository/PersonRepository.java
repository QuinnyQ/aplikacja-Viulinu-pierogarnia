package com.pierogarnia.viulinu.repository;

import com.pierogarnia.viulinu.model.user.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByUsername(String username);
}
