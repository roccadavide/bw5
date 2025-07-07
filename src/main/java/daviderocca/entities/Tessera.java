package daviderocca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Tessera {
    @Id
    @Column(name = "numero_tessera", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @Column(name = "id_utente")
    private Utente utente;

    public Tessera () {};

    public Tessera(String id, LocalDate dataEmissione, Utente utente) {
        this.id = id;
        this.dataEmissione = dataEmissione;
        this.utente = utente;
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
