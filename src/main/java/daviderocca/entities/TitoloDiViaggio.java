package daviderocca.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloDiViaggio {
    @Id
    @Column(name = "id_titolo", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "punto_emissione")
    private String puntoDiEmissione;

    public TitoloDiViaggio () {};

    public TitoloDiViaggio(LocalDate dataEmissione, String puntoDiEmissione) {
        this.dataEmissione = dataEmissione;
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public String getPuntoDiEmissione() {
        return puntoDiEmissione;
    }

    public void setPuntoDiEmissione(String puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id='" + id + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", puntoDiEmissione='" + puntoDiEmissione + '\'' +
                '}';
    }
}
