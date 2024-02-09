package com.example.demo2.dao;

import com.example.demo2.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Long> {
    List<Utente> findByName(String name);

    List<Utente> findByEmail(String email);
}
