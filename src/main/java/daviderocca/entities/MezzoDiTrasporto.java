package daviderocca.entities;

import daviderocca.entities.enums.StatoMezzo;
import daviderocca.entities.enums.TipologiaMezzo;
import jakarta.persistence.*;

@Entity
//RICORDATI DI SETTARE LA TABELLA MANY TO MANY
@Table (name = "mezzi_di_trasporto")
public class MezzoDiTrasporto {

    @Id
    @Column(name = "id_mezzo", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int capienza;
    @Column(name = "stato_mezzo")
    private StatoMezzo statoMezzo;

    @Column(name = "tipologia_mezzo")
    private TipologiaMezzo tipologiaMezzo;

    private Tratta tratta;

    private Biglietto bigliettiObliterati;

    private MezzoDiTrasporto () {};

    public MezzoDiTrasporto(String id, int capienza, StatoMezzo statoMezzo, TipologiaMezzo tipologiaMezzo, Tratta tratta, Biglietto bigliettiObliterati) {
        this.id = id;
        this.capienza = capienza;
        this.statoMezzo = statoMezzo;
        this.tipologiaMezzo = tipologiaMezzo;
        this.tratta = tratta;
        this.bigliettiObliterati=bigliettiObliterati;
    }

    public String getId() {
        return id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatoMezzo getStatoMezzo() {
        return statoMezzo;
    }

    public void setStatoMezzo(StatoMezzo statoMezzo) {
        this.statoMezzo = statoMezzo;
    }

    public TipologiaMezzo getTipologiaMezzo() {
        return tipologiaMezzo;
    }

    public void setTipologiaMezzo(TipologiaMezzo tipologiaMezzo) {
        this.tipologiaMezzo = tipologiaMezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Biglietto getBigliettiObliterati() {
        return bigliettiObliterati;
    }

    public void setBigliettiObliterati(Biglietto bigliettiObliterati) {
        this.bigliettiObliterati = bigliettiObliterati;
    }

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id='" + id + '\'' +
                ", capienza=" + capienza +
                ", statoMezzo=" + statoMezzo +
                ", tipologiaMezzo=" + tipologiaMezzo +
                ", tratta=" + tratta +
                ", bigliettiObliterati=" + bigliettiObliterati +
                '}';
    }
}