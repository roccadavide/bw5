package daviderocca.entities;


import daviderocca.entities.enums.StatoPuntoVendita;
import daviderocca.entities.enums.TipologiaVendita;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "punto_vendita")
public class PuntoVendita {

    @Id
    @Column(name = "id_punto_vendita", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipologia_vendita")
    private TipologiaVendita tipologiaVendita;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_punto_vendita")
    private StatoPuntoVendita statoPuntoVendita;

    private String indirizzo;

    @OneToMany(mappedBy = "puntoVendita")
    private List<TitoloDiViaggio> titoliDiViaggio = new ArrayList<>();

    public PuntoVendita () {};

    public PuntoVendita(TipologiaVendita tipologiaVendita, StatoPuntoVendita statoPuntoVendita, String indirizzo) {
        this.tipologiaVendita = tipologiaVendita;
        this.statoPuntoVendita = statoPuntoVendita;
        this.indirizzo = indirizzo;
    }

    public UUID getId() {
        return id;
    }

    public TipologiaVendita getTipologiaVendita() {
        return tipologiaVendita;
    }

    public void setTipologiaVendita(TipologiaVendita tipologiaVendita) {
        this.tipologiaVendita = tipologiaVendita;
    }

    public StatoPuntoVendita getStatoPuntoVendita() {
        return statoPuntoVendita;
    }

    public void setStatoPuntoVendita(StatoPuntoVendita statoPuntoVendita) {
        this.statoPuntoVendita = statoPuntoVendita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<TitoloDiViaggio> getTitoliDiViaggio() {
        return titoliDiViaggio;
    }

    public void setTitoliDiViaggio(List<TitoloDiViaggio> titoliDiViaggio) {
        this.titoliDiViaggio = titoliDiViaggio;
    }

    @Override
    public String toString() {
        return "PuntoVendita{" +
                "id='" + id + '\'' +
                ", tipologiaVendita=" + tipologiaVendita +
                ", statoPuntoVendita=" + statoPuntoVendita +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
