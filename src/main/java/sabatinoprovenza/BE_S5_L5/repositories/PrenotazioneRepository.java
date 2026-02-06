package sabatinoprovenza.BE_S5_L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sabatinoprovenza.BE_S5_L5.entities.Postazione;
import sabatinoprovenza.BE_S5_L5.entities.Prenotazione;
import sabatinoprovenza.BE_S5_L5.entities.Utente;

import java.time.LocalDate;


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndData(Utente utente, LocalDate data);
}
