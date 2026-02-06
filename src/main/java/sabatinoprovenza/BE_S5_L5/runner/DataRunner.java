package sabatinoprovenza.BE_S5_L5.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sabatinoprovenza.BE_S5_L5.entities.Utente;
import sabatinoprovenza.BE_S5_L5.services.EdificioService;
import sabatinoprovenza.BE_S5_L5.services.PostazioneService;
import sabatinoprovenza.BE_S5_L5.services.PrenotazioneService;
import sabatinoprovenza.BE_S5_L5.services.UtenteService;

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
    }
}
