package daviderocca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//RICORDATI DI SETTARE LA TABELLA MANY TO MANY
public class GuastoMezzo {
    @Id
    @Column (name = "id_guasto")
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @Column (name = "id_mezzo")
    private MezzoDiTrasporto idMezzo;
    @Column(name = "tipologia_guasto")

    private String tipologiaGuasto;
    @Column(name = "data_guasto")
    private LocalDate dataDiGuasto;
    @Column(name = "data_rientro")
    private LocalDate dataDiRitornoInServizio;


    public GuastoMezzo() {};

    public GuastoMezzo(String id, MezzoDiTrasporto idMezzo, String tipologiaGuasto, LocalDate dataDiGuasto, LocalDate dataDiRitornoInServizio) {
        this.id = id;
        this.idMezzo=idMezzo;
        this.tipologiaGuasto = tipologiaGuasto;
        this.dataDiGuasto = dataDiGuasto;
        this.dataDiRitornoInServizio = dataDiRitornoInServizio;
    }

    public String getId() {
        return id;
    }

    public MezzoDiTrasporto getIdMezzo() {
        return idMezzo;
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

    @Override
    public String toString() {
        return "GuastoMezzo{" +
                "id='" + id + '\'' +
                ", idMezzo=" + idMezzo +
                ", tipologiaGuasto='" + tipologiaGuasto + '\'' +
                ", dataDiGuasto=" + dataDiGuasto +
                ", dataDiRitornoInServizio=" + dataDiRitornoInServizio +
                '}';
    }
}
