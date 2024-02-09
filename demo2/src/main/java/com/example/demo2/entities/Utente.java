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
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String username;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazione;

    public Utente(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public Utente() {
    }
}
