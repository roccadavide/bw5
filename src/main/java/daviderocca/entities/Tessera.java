package daviderocca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tessera")
public class Tessera {
    @Id
    @Column(name = "numero_tessera", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID numeroTessera;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @OneToMany(mappedBy = "tessera")
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_utente")
    private Utente utenteTesserato;

    public Tessera () {};

    public Tessera(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public UUID getNumeroTessera() {
        return numeroTessera;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    public Utente getUtenteTesserato() {
        return utenteTesserato;
    }

    public void setUtenteTesserato(Utente utenteTesserato) {
        this.utenteTesserato = utenteTesserato;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "numeroTessera='" + numeroTessera + '\'' +
                ", dataEmissione=" + dataEmissione +
                '}';
    }
}
