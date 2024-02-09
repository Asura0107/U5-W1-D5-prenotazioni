package com.example.demo2.dao;

import com.example.demo2.entities.Prenotazione;
import com.example.demo2.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByUtente(Utente utente);

}
