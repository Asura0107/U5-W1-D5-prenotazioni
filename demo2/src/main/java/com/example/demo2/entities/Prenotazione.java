package com.example.demo2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Prenotazione {
    LocalDate now = LocalDate.now();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
    private LocalDate data;
    private LocalDate durata;

    public Prenotazione(Postazione postazione, Utente utente, LocalDate data) {
        this.utente = utente;
        this.data = data;
        this.durata = data.plusDays(1);
        this.postazione = postazione;

    }

    public Prenotazione(Postazione postazione, Utente utente) {
        this.utente = utente;
        this.data = LocalDate.now();
        this.durata = data.plusDays(1);
        this.postazione = postazione;
    }

    public Prenotazione() {
    }
}
