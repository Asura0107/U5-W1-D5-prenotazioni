package com.example.demo2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String indirizzo;
    private String città;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    public Edificio(String nome, String indirizzo, String città) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    public Edificio() {
    }
}
