package daviderocca.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "titolo_di_viaggio")
public abstract class TitoloDiViaggio {

    @Id
    @Column(name = "id_titolo_di_viaggio", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTitolo;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "id_punto_vendita")
    private PuntoVendita puntoVendita;

    public TitoloDiViaggio () {};

    public TitoloDiViaggio(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public UUID getIdTitolo() {
        return idTitolo;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "idTitolo='" + idTitolo + '\'' +
                ", dataEmissione=" + dataEmissione +
                '}';
    }
}
