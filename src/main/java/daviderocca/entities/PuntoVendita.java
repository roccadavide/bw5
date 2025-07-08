package daviderocca.entities;


import daviderocca.entities.enums.StatoPuntoVendita;
import daviderocca.entities.enums.TipologiaVendita;
import jakarta.persistence.*;

import java.util.UUID;

//RICORDATI DI SETTARE LA TABELLA MANY TO MANY
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

    @Column(name = "titoli_di_viaggio")
    private TitoloDiViaggio titoliDiViaggio;

    public PuntoVendita () {};

    public PuntoVendita(TipologiaVendita tipologiaVendita, StatoPuntoVendita statoPuntoVendita, String indirizzo, TitoloDiViaggio titoliDiViaggio) {
        this.tipologiaVendita = tipologiaVendita;
        this.statoPuntoVendita = statoPuntoVendita;
        this.indirizzo = indirizzo;
        this.titoliDiViaggio=titoliDiViaggio;
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

    public TitoloDiViaggio getTitoliDiViaggio() {
        return titoliDiViaggio;
    }

    public void setTitoliDiViaggio(TitoloDiViaggio titoliDiViaggio) {
        this.titoliDiViaggio = titoliDiViaggio;
    }

    @Override
    public String toString() {
        return "PuntoVendita{" +
                "id='" + id + '\'' +
                ", tipologiaVendita=" + tipologiaVendita +
                ", statoPuntoVendita=" + statoPuntoVendita +
                ", indirizzo='" + indirizzo + '\'' +
                ", titoliDiViaggio=" + titoliDiViaggio +
                '}';
    }
}
