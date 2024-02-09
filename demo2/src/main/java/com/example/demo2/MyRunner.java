package com.example.demo2;

import com.example.demo2.Enum.TipoPostazione;
import com.example.demo2.entities.Edificio;
import com.example.demo2.entities.Postazione;
import com.example.demo2.entities.Prenotazione;
import com.example.demo2.entities.Utente;
import com.example.demo2.services.EdificioService;
import com.example.demo2.services.PostazioneService;
import com.example.demo2.services.PrenotazioneService;
import com.example.demo2.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {
        Utente utente = new Utente("io", "m", "m");
        utenteService.save(utente);
        Edificio edificio = new Edificio("f", "d", "d");
        edificioService.save(edificio);
        Postazione postazione = new Postazione("h", TipoPostazione.OPENSPACE, 4, edificio, 1);
        postazioneService.save(postazione);
        Prenotazione prenotazione = new Prenotazione(postazione, utente);
        prenotazioneService.save(prenotazione);
    }
}
