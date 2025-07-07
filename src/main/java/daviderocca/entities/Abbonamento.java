package daviderocca.entities;

import daviderocca.entities.enums.TipoAbbonamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name="abbonamenti")
public class Abbonamento extends TitoloDiViaggio{
@Column(name = "tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;
@Column(name = "numero_tessera")
    private int numeroTessera;

    private Abbonamento () {};


    public Abbonamento(String id, LocalDate dataEmissione, String puntoDiEmissione, TipoAbbonamento tipoAbbonamento, int numeroTessera) {
        super(id, dataEmissione, puntoDiEmissione);
        this.tipoAbbonamento = tipoAbbonamento;
        this.numeroTessera = numeroTessera;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tipoAbbonamento=" + tipoAbbonamento +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}
