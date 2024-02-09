package com.example.demo2.dao;

import com.example.demo2.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
//    List<Postazione> findBytipoPostazioneAndcittà(TipoPostazione tipoPostazione, String città);

}
