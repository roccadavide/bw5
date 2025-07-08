package daviderocca.entities;

import daviderocca.entities.enums.TipoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name="abbonamenti")
public class Abbonamento extends TitoloDiViaggio {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;

    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private Tessera tessera;

    private Abbonamento () {};


    public Abbonamento(LocalDate dataEmissione, TipoAbbonamento tipoAbbonamento) {
        super(dataEmissione);
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tipoAbbonamento=" + tipoAbbonamento +
                '}';
    }
}
