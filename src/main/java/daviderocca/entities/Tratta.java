package daviderocca.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {

    @Id
    @Column(name = "id_tratta", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "punto_partenza")
    private String partenza;

    @Column(name = "punto_arrivo")
    private String arrivo;

    @Column(name = "tempo_percorrenza_previsto")
    private double tempoPrevistoTratta;

    @OneToMany(mappedBy = "tratta")
    private List<StoricoPercorrenze> storiciPercorrenze = new ArrayList<>();

    public Tratta () {};

    public Tratta(String partenza, String arrivo, double tempoPrevistoTratta) {
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.tempoPrevistoTratta = tempoPrevistoTratta;
    }

    public UUID getId() {
        return id;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public void setArrivo(String arrivo) {
        this.arrivo = arrivo;
    }

    public double getTempoPrevistoTratta() {
        return tempoPrevistoTratta;
    }

    public void setTempoPrevistoTratta(double tempoPrevistoTratta) {
        this.tempoPrevistoTratta = tempoPrevistoTratta;
    }

    public List<StoricoPercorrenze> getStoriciPercorrenze() {
        return storiciPercorrenze;
    }

    public void setStoriciPercorrenze(List<StoricoPercorrenze> storiciPercorrenze) {
        this.storiciPercorrenze = storiciPercorrenze;
    }

    @Override
    public String toString() {
        return "Tratta: " + getPartenza() + "-"
                + getArrivo()
                + " Tempo previsto: "
                + getTempoPrevistoTratta() + " minuti.";
    }
}
