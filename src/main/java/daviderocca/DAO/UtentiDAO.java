package daviderocca.DAO;

import daviderocca.entities.Utente;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtentiDAO {

    private final EntityManager entityManager;

    public UtentiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente utente) {
        EntityTransaction et = entityManager.getTransaction();

        et.begin();
        entityManager.persist(utente);
        et.commit();

        System.out.println("L'utente " + utente.getNome() + " "+ utente.getCognome() + " è stato salvato.");
    }

    public Utente findById(UUID id) {
        Utente trovato = entityManager.find(Utente.class, id);
        if (trovato == null)
            throw new NotFoundException(id);
        return trovato;
    }

    public void deleteById(UUID id) {
        Utente daEliminare = this.findById(id);

        EntityTransaction et = entityManager.getTransaction();

        et.begin();
        entityManager.remove(daEliminare);
        et.commit();

        System.out.println("L'utente " + daEliminare.getNome() + " "+ daEliminare.getCognome() + " è stato eliminato.");
    }
}
