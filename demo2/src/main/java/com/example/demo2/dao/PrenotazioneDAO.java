package com.example.demo2.dao;

import com.example.demo2.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
}
