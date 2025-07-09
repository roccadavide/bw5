package daviderocca.entities;


import daviderocca.enums.StatoDistributore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "punto_vendita")
public abstract class PuntoVendita {

    @Id
    @Column(name = "id_punto_vendita", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String indirizzo;

    @OneToMany(mappedBy = "puntoVendita")
    private List<TitoloDiViaggio> titoliDiViaggio = new ArrayList<>();



    public PuntoVendita () {};

    public PuntoVendita(String indirizzo) {
        this.indirizzo = indirizzo;
    }



    public UUID getId() {
        return id;
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
                "id=" + id +
                ", indirizzo='" + indirizzo + '\'' +
                ", titoliDiViaggio=" + titoliDiViaggio +
                '}';
    }
}
