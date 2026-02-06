package sabatinoprovenza.BE_S5_L5.services;

import org.springframework.stereotype.Service;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.repositories.PostazioneRepository;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void save(Postazione p) {
        postazioneRepository.save(p);
        System.out.println("La postazione " + p.getDescrizione() + " " + " è stata salvata!");
    }
}
