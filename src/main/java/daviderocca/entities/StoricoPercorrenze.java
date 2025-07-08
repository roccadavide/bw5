package daviderocca.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "storico_percorrenze")
public class StoricoPercorrenze {

    @Id
    @Column(name = "id_storico_percorrenze", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto mezzoDiTrasporto;

    @ManyToOne
    @JoinColumn(name = "id_tratta")
    private Tratta tratta;

    @Column(name = "tempo_effettivo_tratta")
    private double tempoEffettivoTratta;

    public StoricoPercorrenze(double tempoEffettivoTratta) {
        this.tempoEffettivoTratta = tempoEffettivoTratta;
    }

    public UUID getId() {
        return id;
    }

    public MezzoDiTrasporto getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public double getTempoEffettivoTratta() {
        return tempoEffettivoTratta;
    }

    public void setTempoEffettivoTratta(double tempoEffettivoTratta) {
        this.tempoEffettivoTratta = tempoEffettivoTratta;
    }

    @Override
    public String toString() {
        return "StoricoPercorrenze{" +
                "id='" + id + '\'' +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                ", tratta=" + tratta +
                ", tempoEffettivoTratta=" + tempoEffettivoTratta +
                '}';
    }
}
