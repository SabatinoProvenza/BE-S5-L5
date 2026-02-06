package sabatinoprovenza.BE_S5_L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sabatinoprovenza.BE_S5_L5.entities.Prenotazione;


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
