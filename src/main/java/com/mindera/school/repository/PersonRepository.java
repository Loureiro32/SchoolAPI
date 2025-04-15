package com.mindera.school.repository;

import com.mindera.school.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByEmail(String email);
}
