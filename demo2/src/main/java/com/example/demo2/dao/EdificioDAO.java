package com.example.demo2.dao;

import com.example.demo2.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {
    List<Edificio> findByCittà(String città);
}
