package borislavk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "rivenditori_autorizzati")
public class RivenditoreAutorizzato extends PuntoVendita{

    @Column (name = "orari_apertura")
    private LocalTime orarioApertura;

    @Column (name = "orari_chiusura")
    private LocalTime orarioChiusura;

    public RivenditoreAutorizzato(String indirizzo, LocalTime orarioApertura, LocalTime orarioChiusura) {
        super(indirizzo);
        this.orarioApertura = orarioApertura;
        this.orarioChiusura = orarioChiusura;
    }

    public RivenditoreAutorizzato() {
    }

    public LocalTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public LocalTime getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(LocalTime orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "orarioApertura=" + orarioApertura +
                ", orarioChiusura=" + orarioChiusura +
                '}';
    }
}

