package com.example.demo2.services;

import com.example.demo2.dao.PostazioneDAO;
import com.example.demo2.entities.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void save(Postazione postazione) {
        postazioneDAO.save(postazione);
        System.out.println("creato");
    }

//    public List<Postazione> findBytipoPostazioneAndcittà(TipoPostazione tipoPostazione, String città) {
//        return postazioneDAO.findBytipoPostazioneAndcittà(tipoPostazione, città);
//    }
}
