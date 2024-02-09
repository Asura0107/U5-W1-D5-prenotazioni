package com.example.demo2.services;

import com.example.demo2.dao.EdificioDAO;
import com.example.demo2.entities.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioDAO edificioDAO;

    public void save(Edificio edificio) {
        edificioDAO.save(edificio);
        System.out.println("creato");
    }
}
