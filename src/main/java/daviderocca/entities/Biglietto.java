package daviderocca.entities;

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

    public Biglietto () {};

    public Biglietto(LocalDate dataEmissione, String puntoDiEmissione, LocalDate dataObliterazione) {
        super(dataEmissione, puntoDiEmissione);
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
