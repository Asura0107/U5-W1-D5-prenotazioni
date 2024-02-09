package com.example.demo2.services;

import com.example.demo2.Enum.TipoPostazione;
import com.example.demo2.dao.PostazioneDAO;
import com.example.demo2.entities.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void save(Postazione postazione) {
        postazioneDAO.save(postazione);
        System.out.println("creato");
    }

    public List<Postazione> findCittaoTipoPostazione(TipoPostazione tipoPostazione, String città) {
        return postazioneDAO.findByPostazioneAndCittà(tipoPostazione, città);
    }

    public List<Postazione> findByTipo(TipoPostazione tipoPostazione) {
        return postazioneDAO.findByTipoPostazione(tipoPostazione);
    }

}
