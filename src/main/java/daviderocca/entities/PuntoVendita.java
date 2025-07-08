package daviderocca.entities;


import daviderocca.entities.enums.StatoPuntoVendita;
import daviderocca.entities.enums.TipologiaVendita;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//RICORDATI DI SETTARE LA TABELLA MANY TO MANY
public class PuntoVendita {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private TipologiaVendita tipologiaVendita;

    private StatoPuntoVendita statoPuntoVendita;

    private String indirizzo;

    private TitoloDiViaggio titoliDiViaggio;

    public PuntoVendita () {};

    public PuntoVendita(String id, TipologiaVendita tipologiaVendita, StatoPuntoVendita statoPuntoVendita, String indirizzo, TitoloDiViaggio titoliDiViaggio) {
        this.id = id;
        this.tipologiaVendita = tipologiaVendita;
        this.statoPuntoVendita = statoPuntoVendita;
        this.indirizzo = indirizzo;
        this.titoliDiViaggio=titoliDiViaggio;
    }

    public String getId() {
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
