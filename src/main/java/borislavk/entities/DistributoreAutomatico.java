package borislavk.entities;

import borislavk.enums.StatoDistributore;
import jakarta.persistence.*;

@Entity
@Table (name = "distributori_automatici")
public class DistributoreAutomatico extends PuntoVendita{

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_distributore_automatico")
    private StatoDistributore statoDistributore;



    public DistributoreAutomatico(String indirizzo,StatoDistributore statoDistributore) {
        super(indirizzo);
        this.statoDistributore = statoDistributore;
    }

    public DistributoreAutomatico() {
    }

    public StatoDistributore getStatoDistributore() {
        return statoDistributore;
    }

    public void setStatoDistributore(StatoDistributore statoDistributore) {
        this.statoDistributore = statoDistributore;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "statoDistributore=" + statoDistributore +
                '}';
    }
}

