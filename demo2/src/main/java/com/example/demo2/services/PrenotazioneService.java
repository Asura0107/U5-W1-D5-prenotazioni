package com.example.demo2.services;

import com.example.demo2.dao.PrenotazioneDAO;
import com.example.demo2.entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void save(Prenotazione prenotazione) {
        prenotazioneDAO.save(prenotazione);
        System.out.println("creato");
    }
}
