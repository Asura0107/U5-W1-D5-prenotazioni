package com.example.demo2.entities;

import com.example.demo2.Enum.TipoPostazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descrizione;

    private TipoPostazione tipoPostazione;

    private int maxpersone;
    private int personeattuali;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazione;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipoPostazione, int maxpersone, Edificio edificio, int personeattuali) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxpersone = maxpersone;
        this.edificio = edificio;
        this.personeattuali = personeattuali;
    }

    public Postazione() {
    }


}
