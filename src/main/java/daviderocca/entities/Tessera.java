package daviderocca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

public class Tessera {
    @Id
    @Column(name = "numero_tessera", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @Column(name = "id_utente")
    private Utente utente;

    public Tessera () {};

    public Tessera(LocalDate dataEmissione, Utente utente) {
        this.dataEmissione = dataEmissione;
        this.utente = utente;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id='" + id + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", utente=" + utente +
                '}';
    }
}
