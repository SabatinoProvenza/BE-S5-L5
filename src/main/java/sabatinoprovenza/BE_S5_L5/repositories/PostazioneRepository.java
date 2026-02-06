package sabatinoprovenza.BE_S5_L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.entities.TipoPostazione;

import java.util.List;


public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipo(TipoPostazione tipo);

    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}

