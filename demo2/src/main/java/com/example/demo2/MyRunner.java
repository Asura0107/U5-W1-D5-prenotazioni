package com.example.demo2;

import com.example.demo2.Enum.TipoPostazione;
import com.example.demo2.dao.PostazioneDAO;
import com.example.demo2.entities.Edificio;
import com.example.demo2.entities.Postazione;
import com.example.demo2.entities.Prenotazione;
import com.example.demo2.entities.Utente;
import com.example.demo2.services.EdificioService;
import com.example.demo2.services.PostazioneService;
import com.example.demo2.services.PrenotazioneService;
import com.example.demo2.services.UtenteService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    PostazioneDAO postazioneDAO;

    //mi serve per prendere un enum random
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumeration) {
        Random random = new Random();
        T[] values = enumeration.getEnumConstants();
        return values[random.nextInt(values.length)];
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();
        Random r = new Random();
        List<Edificio> edificios = new ArrayList<>();
        List<Postazione> postazioni = new ArrayList<>();
        List<Utente> utenti = new ArrayList<>();


        System.out.println("------------------------------UTENTI---------------------------------");
        for (int i = 0; i < 20; i++) {
            Utente utente = new Utente(faker.name().name(), faker.name().username(), faker.internet().emailAddress());
            utenteService.save(utente);
            utenti.add(utente);
        }

        System.out.println("------------------------------EDIFICI---------------------------------");
        for (int i = 0; i < 6; i++) {
            Edificio edificio = new Edificio(faker.address().firstName(), faker.address().streetAddress(), faker.address().city());
            edificioService.save(edificio);
            edificios.add(edificio);
        }

        System.out.println("------------------------------POSTAZIONE---------------------------------");
        for (int i = 0; i < 15; i++) {
            Edificio edcas = edificios.get(r.nextInt(edificios.size()));
            Postazione postazione = new Postazione(faker.lorem().characters(), getRandomEnum(TipoPostazione.class), r.nextInt(10, 50), edcas, r.nextInt(10, 60));
            if (postazione.getMaxpersone() < postazione.getPersoneattuali()) {
                postazione = null;
            } else {

                postazioneService.save(postazione);
            }
            postazioni.add(postazione);
        }

        System.out.println("------------------------------PRENOTAZIONI---------------------------------");
        for (int i = 0; i < 20; i++) {
            Utente utcas = utenti.get(r.nextInt(utenti.size()));
            Postazione poscas = postazioni.get(r.nextInt(postazioni.size()));
            Prenotazione prenotazione = new Prenotazione(poscas, utcas);
            if (prenotazione.getDurata().isBefore(LocalDate.now()) || poscas == null || prenotazione.getDurata() == null) {
                continue;
            }

            prenotazioneService.save(prenotazione);

        }

        System.out.println("----------find by tipopostazione e città------------");
        postazioneService.findCittaoTipoPostazione(TipoPostazione.OPENSPACE, "Lake Myles");

        System.out.println("----------find by tipopostazione------------");
        postazioneService.findByTipo(TipoPostazione.PRIVATO);

        System.out.println("----------find by nameutente------------");
        utenteService.filterByName("Mirco");

        System.out.println("----------find by usernameutente------------");
        utenteService.filterByUsername("mirc04");

    }
}
