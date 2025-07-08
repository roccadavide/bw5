package daviderocca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "guasti_mezzo")
public class GuastoMezzo {
    @Id
    @Column (name = "id_guasto", nullable = false)
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tipologia_guasto")
    private String tipologiaGuasto;

    @Column(name = "data_guasto")
    private LocalDate dataDiGuasto;

    @Column(name = "data_rientro")
    private LocalDate dataDiRitornoInServizio;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto mezzoDiTrasporto;


    public GuastoMezzo() {};

    public GuastoMezzo(String tipologiaGuasto, LocalDate dataDiGuasto, LocalDate dataDiRitornoInServizio) {
        this.tipologiaGuasto = tipologiaGuasto;
        this.dataDiGuasto = dataDiGuasto;
        this.dataDiRitornoInServizio = dataDiRitornoInServizio;
    }


    public UUID getId() {
        return id;
    }

    public String getTipologiaGuasto() {
        return tipologiaGuasto;
    }

    public void setTipologiaGuasto(String tipologiaGuasto) {
        this.tipologiaGuasto = tipologiaGuasto;
    }

    public LocalDate getDataDiGuasto() {
        return dataDiGuasto;
    }

    public void setDataDiGuasto(LocalDate dataDiGuasto) {
        this.dataDiGuasto = dataDiGuasto;
    }

    public LocalDate getDataDiRitornoInServizio() {
        return dataDiRitornoInServizio;
    }

    public void setDataDiRitornoInServizio(LocalDate dataDiRitornoInServizio) {
        this.dataDiRitornoInServizio = dataDiRitornoInServizio;
    }

    public MezzoDiTrasporto getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    @Override
    public String toString() {
        return "GuastoMezzo{" +
                "id='" + id + '\'' +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                ", tipologiaGuasto='" + tipologiaGuasto + '\'' +
                ", dataDiGuasto=" + dataDiGuasto +
                ", dataDiRitornoInServizio=" + dataDiRitornoInServizio +
                '}';
    }
}
