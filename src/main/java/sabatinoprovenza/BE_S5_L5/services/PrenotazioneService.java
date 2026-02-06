package sabatinoprovenza.BE_S5_L5.services;

import org.springframework.stereotype.Service;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.entities.Prenotazione;
import sabatinoprovenza.BE_S5_L5.entities.Utente;
import sabatinoprovenza.BE_S5_L5.exceptions.PrenotazioneException;
import sabatinoprovenza.BE_S5_L5.repositories.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteService utenteService;
    private final PostazioneService postazioneService;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UtenteService utenteService, PostazioneService postazioneService) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteService = utenteService;
        this.postazioneService = postazioneService;
    }

    public void prenota(Long utenteId, Long postazioneId, LocalDate data) {

        Utente utente = utenteService.findById(utenteId);
        Postazione postazione = postazioneService.findById(postazioneId);

        if (prenotazioneRepository.existsByUtenteAndData(utente, data)) {
            throw new PrenotazioneException("Utente già prenotato per la data: " + data);
        }

        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            throw new PrenotazioneException("Postazione già occupata per la data: " + data);
        }

        Prenotazione p = new Prenotazione();
        p.setUtente(utente);
        p.setPostazione(postazione);
        p.setData(data);
        prenotazioneRepository.save(p);
        System.out.println("La prenotazione con id: " + p.getId() + " è stata salvata correttamente");
    }

    public List<Prenotazione> findAll() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        if (prenotazioni.isEmpty())
            System.out.println("Non ci sono prenotazioni registrate");
        return prenotazioni;
    }


}
