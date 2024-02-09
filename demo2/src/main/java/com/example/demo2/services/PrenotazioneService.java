package com.example.demo2.services;

import com.example.demo2.dao.PrenotazioneDAO;
import com.example.demo2.entities.Prenotazione;
import com.example.demo2.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void save(Prenotazione prenotazione) {
        prenotazioneDAO.save(prenotazione);
        System.out.println("creato");
    }

//    public List<Prenotazione> filterData(LocalDate data) {
//        return prenotazioneDAO.filterByData(data);
//    }

    public List<Prenotazione> AlreadyBooked(Utente utente) {
        return prenotazioneDAO.findByUtente(utente);
    }
}
