package sabatinoprovenza.BE_S5_L5.services;

import org.springframework.stereotype.Service;
import sabatinoprovenza.BE_S5_L5.entities.Edificio;
import sabatinoprovenza.BE_S5_L5.repositories.EdificioRepository;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public void save(Edificio e) {
        edificioRepository.save(e);
        System.out.println("L'edificio " + e.getNome() + " è stato salvato!");
    }
}
