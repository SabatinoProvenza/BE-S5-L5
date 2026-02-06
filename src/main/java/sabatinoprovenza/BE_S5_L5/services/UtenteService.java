package sabatinoprovenza.BE_S5_L5.services;

import org.springframework.stereotype.Service;
import sabatinoprovenza.BE_S5_L5.entities.Utente;
import sabatinoprovenza.BE_S5_L5.exceptions.NotFoundException;
import sabatinoprovenza.BE_S5_L5.repositories.UtenteRepository;

import java.util.Optional;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void save(Utente u) {
        utenteRepository.save(u);
        System.out.println("L'utente " + u.getNome() + " " + u.getCognome() + " è stato salvato!");
    }

    public Utente findById(Long id) {
        Optional<Utente> found = utenteRepository.findById(id);
        if (found.isPresent()) return found.get();
        else throw new NotFoundException("L'utente con id: " + id + " non è stato trovato");
    }
}
