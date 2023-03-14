package org.prog.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsJpa extends JpaRepository<Persons, Long> {
    List<Persons> findAllByFirstName(String firstName);
}
