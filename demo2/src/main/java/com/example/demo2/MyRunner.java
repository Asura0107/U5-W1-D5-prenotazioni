package com.example.demo2;

import com.example.demo2.entities.Utente;
import com.example.demo2.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        Utente utente=new Utente("io","m","m");
        utenteService.save(utente);
    }
}
