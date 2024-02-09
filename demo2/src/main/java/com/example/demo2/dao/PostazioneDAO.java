package com.example.demo2.dao;

import com.example.demo2.Enum.TipoPostazione;
import com.example.demo2.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione=:tipoPostazione OR p.edificio.città LIKE :città")
    List<Postazione> findByPostazioneAndCittà(TipoPostazione tipoPostazione, String città);

}
