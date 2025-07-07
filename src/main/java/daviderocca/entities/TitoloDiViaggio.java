package daviderocca.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloDiViaggio {
    @Id
    @Column(name = "id_titolo", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "punto_emissione")
    private String puntoDiEmissione;

    public TitoloDiViaggio () {};

    public TitoloDiViaggio(String id, LocalDate dataEmissione, String puntoDiEmissione) {
        this.id = id;
        this.dataEmissione = dataEmissione;
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public String getId() {
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
