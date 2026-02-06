package sabatinoprovenza.BE_S5_L5.services;

import org.springframework.stereotype.Service;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.entities.TipoPostazione;
import sabatinoprovenza.BE_S5_L5.exceptions.NotFoundException;
import sabatinoprovenza.BE_S5_L5.repositories.PostazioneRepository;

import java.util.List;
import java.util.Optional;

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

    public Postazione findById(Long id) {
        Optional<Postazione> found = postazioneRepository.findById(id);
        if (found.isPresent()) return found.get();
        else throw new NotFoundException("La postazione con id: " + id + " non è stata trovata");
    }


    public List<Postazione> findByTipo(TipoPostazione tipo) {
        List<Postazione> lista = postazioneRepository.findByTipo(tipo);

        if (lista.isEmpty()) {
            System.out.println("Nessuna postazione trovata per il tipo: " + tipo);
        }

        return lista;
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {

        List<Postazione> lista = postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);

        if (lista.isEmpty()) {
            System.out.println("Nessuna postazione trovata per il tipo: " + tipo + " nella città: " + citta);
        }

        return lista;
    }

    public List<Postazione> findByMaxOccupantiGreaterThanEqual(int numero) {
        List<Postazione> lista = postazioneRepository.findByMaxOccupantiGreaterThanEqual(numero);

        if (lista.isEmpty()) {
            System.out.println("Nessuna postazione trovata con posti disponibili maggiori di: " + numero);
        }

        return lista;
    }
}
