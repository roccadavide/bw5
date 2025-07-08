package daviderocca.dao;

import daviderocca.entities.PuntoVendita;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PuntiVenditaDAO {
    private final EntityManager entityManager;

    public PuntiVenditaDAO(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    public void savePuntoVendita(PuntoVendita newPuntoVendita) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPuntoVendita);
        transaction.commit();

        System.out.println("Il punto vendita " + newPuntoVendita.getId() + " all'indirizzo "+ newPuntoVendita.getIndirizzo()
                + " è stato aggiunto al database");
    }

    public PuntoVendita findById(UUID PuntoVendita_id) {
        PuntoVendita found = entityManager.find(PuntoVendita.class, PuntoVendita_id);
        if (found == null) throw new NotFoundException(PuntoVendita_id);
        return found;
    }

    public void deletePuntoVendita(PuntoVendita puntoVendita) {
        PuntoVendita found = this.findById(puntoVendita.getId());

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Il punto vendita " + puntoVendita.getId() + " all'indirizzo "+ puntoVendita.getIndirizzo()
                + " è stato rimosso dal database");
    }

    //tutti i metodi di PuntiVenditaDAO sono testati e funzionanti
}
