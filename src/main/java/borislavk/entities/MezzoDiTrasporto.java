package borislavk.entities;

import borislavk.enums.StatoMezzo;
import borislavk.enums.TipologiaMezzo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "mezzi_di_trasporto")
public class MezzoDiTrasporto {

    @Id
    @Column(name = "id_mezzo", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "capienza")
    private int capienzaMassima;

    @Column(name = "numero_passeggeri_attuali")
    private int numeroPasseggeriAttuali;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_mezzo")
    private StatoMezzo statoMezzo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipologia_mezzo")
    private TipologiaMezzo tipologiaMezzo;

    @OneToMany(mappedBy = "mezzoDiTrasporto")
    private List<Biglietto> bigliettiObliterati = new ArrayList<>();

    @OneToMany(mappedBy = "mezzoDiTrasporto")
    private List<StoricoPercorrenze> storiciPercorrenze = new ArrayList<>();

    @OneToMany(mappedBy = "mezzoDiTrasporto")
    private List<GuastoMezzo> guastiMezzo = new ArrayList<>();

    private MezzoDiTrasporto () {};

    public MezzoDiTrasporto(int capienzaMassima, int numeroPasseggeriAttuali, StatoMezzo statoMezzo, TipologiaMezzo tipologiaMezzo) {
        this.capienzaMassima = capienzaMassima;
        this.numeroPasseggeriAttuali = numeroPasseggeriAttuali;
        this.statoMezzo = statoMezzo;
        this.tipologiaMezzo = tipologiaMezzo;
    }

    public UUID getId() {
        return id;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public void setCapienzaMassima(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public int getNumeroPasseggeriAttuali() {
        return numeroPasseggeriAttuali;
    }

    public void setNumeroPasseggeriAttuali(int numeroPasseggeriAttuali) {
        this.numeroPasseggeriAttuali = numeroPasseggeriAttuali;
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

    public List<Biglietto> getBigliettiObliterati() {
        return bigliettiObliterati;
    }

    public void setBigliettiObliterati(List<Biglietto> bigliettiObliterati) {
        this.bigliettiObliterati = bigliettiObliterati;
    }

    public List<StoricoPercorrenze> getStoriciPercorrenze() {
        return storiciPercorrenze;
    }

    public void setStoriciPercorrenze(List<StoricoPercorrenze> storiciPercorrenze) {
        this.storiciPercorrenze = storiciPercorrenze;
    }

    public List<GuastoMezzo> getGuastiMezzo() {
        return guastiMezzo;
    }

    public void setGuastiMezzo(List<GuastoMezzo> guastiMezzo) {
        this.guastiMezzo = guastiMezzo;
    }

    @Override
    public String toString() {
        return "||" + tipologiaMezzo + " ||Numero passeggeri attuale: " + numeroPasseggeriAttuali + " ||Capienza massima: " + capienzaMassima + " persone ||Stato: " + statoMezzo;
    }
}