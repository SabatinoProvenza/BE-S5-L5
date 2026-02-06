package sabatinoprovenza.BE_S5_L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni = new ArrayList<>();

    public Edificio(String nome, String indirizzo, String citta, List<Postazione> postazioni) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.postazioni = postazioni;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "nome='" + nome + '\'' +
                '}';
    }
}