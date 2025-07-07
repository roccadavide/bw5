package daviderocca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//RICORDATI DI SETTARE LA TABELLA MANY TO MANY
public class TipoGuasto {
    @Id
    @Column (name = "id_guasto")
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    @Column(name = "tipologia_guasto")
    private String tipologiaGuasto;
    @Column(name = "data_guasto")
    private LocalDate dataDiGuasto;
    @Column(name = "data_rientro")
    private LocalDate dataDiRitornoInServizio;

    public TipoGuasto () {};

    public TipoGuasto(String id, String tipologiaGuasto, LocalDate dataDiGuasto, LocalDate dataDiRitornoInServizio) {
        this.id = id;
        this.tipologiaGuasto = tipologiaGuasto;
        this.dataDiGuasto = dataDiGuasto;
        this.dataDiRitornoInServizio = dataDiRitornoInServizio;
    }

    public String getId() {
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

    @Override
    public String toString() {
        return "TipoGuasto{" +
                "id='" + id + '\'' +
                ", tipologiaGuasto='" + tipologiaGuasto + '\'' +
                ", dataDiGuasto=" + dataDiGuasto +
                ", dataDiRitornoInServizio=" + dataDiRitornoInServizio +
                '}';
    }
}
