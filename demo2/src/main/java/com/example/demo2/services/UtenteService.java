package com.example.demo2.services;


import com.example.demo2.dao.UtenteDAO;
import com.example.demo2.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void save(Utente utente) {
        utenteDAO.save(utente);
        System.out.println("creato");
    }
}
