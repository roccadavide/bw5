package borislavk.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "biglietti")
public class Biglietto extends TitoloDiViaggio {

    @Column(name = "data_obliterazione")
    private LocalDate dataObliterazione;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto mezzoDiTrasporto;

    //è normale che sia il biglietto a gestire la relazione e contenere id_mezzo perché è ManyToOne,
    //e in questo tipo di relazione è sempre Many che "comanda";
    //questo non inficia la creazione di una lista di biglietti obliterati in MezzoDiTrasporto
    //poiché viene creata in esso una lista di biglietti obliterati

    public Biglietto () {};

    public Biglietto(LocalDate dataEmissione, LocalDate dataObliterazione) {
        super(dataEmissione);
        this.dataObliterazione = dataObliterazione;
    }

    public LocalDate getDataObliterazione() {
        return dataObliterazione;
    }

    public void setDataObliterazione(LocalDate dataObliterazione) {
        this.dataObliterazione = dataObliterazione;
    }

    public MezzoDiTrasporto getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "dataObliterazione=" + dataObliterazione +
                '}';
    }
}
