package sabatinoprovenza.BE_S5_L5.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sabatinoprovenza.BE_S5_L5.entities.Edificio;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.entities.TipoPostazione;
import sabatinoprovenza.BE_S5_L5.entities.Utente;
import sabatinoprovenza.BE_S5_L5.services.EdificioService;
import sabatinoprovenza.BE_S5_L5.services.PostazioneService;
import sabatinoprovenza.BE_S5_L5.services.PrenotazioneService;
import sabatinoprovenza.BE_S5_L5.services.UtenteService;

import java.util.List;

@Component
public class DataRunner implements CommandLineRunner {
    private final UtenteService utenteService;
    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;

    public DataRunner(UtenteService utenteService, EdificioService edificioService, PostazioneService postazioneService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) throws Exception {

        // UTENTI
        Utente u1 = new Utente();
        u1.setNome("Mario");
        u1.setCognome("Rossi");
        u1.setEmail("mario.rossi@mail.it");
        // utenteService.save(u1);

        Utente u2 = new Utente();
        u2.setNome("Laura");
        u2.setCognome("Bianchi");
        u2.setEmail("laura.bianchi@mail.it");
        // utenteService.save(u2);

        Utente u3 = new Utente();
        u3.setNome("Luigi");
        u3.setCognome("Verdi");
        u3.setEmail("luigi.verdi@mail.it");
        //utenteService.save(u3);

        // EDIFICI
        Edificio e1 = new Edificio();
        e1.setNome("HQ Roma");
        e1.setIndirizzo("Via Roma 10");
        e1.setCitta("Roma");
        //edificioService.save(e1);

        Edificio e2 = new Edificio();
        e2.setNome("Hub Milano");
        e2.setIndirizzo("Corso Milano 25");
        e2.setCitta("Milano");
        //edificioService.save(e2);

        // POSTAZIONI
        Postazione p1 = new Postazione();
        p1.setDescrizione("Postazione privata vicino finestra");
        p1.setTipo(TipoPostazione.PRIVATO);
        p1.setMaxOccupanti(1);
        p1.setEdificio(e1);
        //postazioneService.save(p1);

        Postazione p2 = new Postazione();
        p2.setDescrizione("Open space centrale");
        p2.setTipo(TipoPostazione.OPENSPACE);
        p2.setMaxOccupanti(12);
        p2.setEdificio(e1);
        //postazioneService.save(p2);

        Postazione p3 = new Postazione();
        p3.setDescrizione("Sala riunioni con proiettore");
        p3.setTipo(TipoPostazione.SALA_RIUNIONI);
        p3.setMaxOccupanti(8);
        p3.setEdificio(e2);
        //postazioneService.save(p3);

        List<Postazione> postazioniOpenSpace = postazioneService.findByTipo(TipoPostazione.OPENSPACE);

        System.out.println("POSTAZIONI OPENSPACE:");
        postazioniOpenSpace.forEach(p -> System.out.println(p.getEdificio() + " - " + p.getDescrizione()));

    }
}
