package daviderocca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tratte")
public class Tratta {
    @Id
    @Column(name = "id_tratta", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "punto_partenza")
    private String partenza;

    @Column(name = "punto_arrivo")
    private String arrivo;

    @Column(name = "tempo_percorrenza_previsto")
    private double tempoPrevistoTratta;


    public Tratta () {};

    public Tratta(String id, String partenza, String arrivo, double tempoPrevistoTratta, double tempoEffettivoTratta) {
        this.id = id;
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.tempoPrevistoTratta = tempoPrevistoTratta;
    }

    public String getId() {
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


    @Override
    public String toString() {
        return "Tratta{" +
                "id='" + id + '\'' +
                ", partenza='" + partenza + '\'' +
                ", arrivo='" + arrivo + '\'' +
                ", tempoPrevistoTratta=" + tempoPrevistoTratta +
                '}';
    }
}
