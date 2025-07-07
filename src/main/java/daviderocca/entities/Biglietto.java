package daviderocca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "biglietti")
public class Biglietto extends TitoloDiViaggio {
    @Column(name = "data_obliterazione")
    private LocalDate dataObliterazione;

    public Biglietto () {};

    public Biglietto(String id, LocalDate dataEmissione, String puntoDiEmissione, LocalDate dataObliterazione) {
        super(id, dataEmissione, puntoDiEmissione);
        this.dataObliterazione = dataObliterazione;
    }

    public LocalDate getDataObliterazione() {
        return dataObliterazione;
    }

    public void setDataObliterazione(LocalDate dataObliterazione) {
        this.dataObliterazione = dataObliterazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "dataObliterazione=" + dataObliterazione +
                '}';
    }
}
