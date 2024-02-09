package com.example.demo2.dao;

import com.example.demo2.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> filterByData(LocalDate data);
}
