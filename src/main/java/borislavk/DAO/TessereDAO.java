package borislavk.DAO;

import borislavk.entities.Tessera;
import borislavk.entities.Utente;
import borislavk.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.UUID;

public class TessereDAO {

    private final EntityManager entityManager;

    public TessereDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Tessera tessera) {

        EntityTransaction et= entityManager.getTransaction();

        et.begin();

        entityManager.persist(tessera);

        et.commit();

        System.out.println("la tessera " + tessera + " è stata correttamente salvata");
    }

    public Tessera findById(UUID id) {
        Tessera trovata= entityManager.find(Tessera.class,id);
        if (trovata==null)
            throw new NotFoundException(id);

        return  trovata;
    }

    public Tessera findByUtente(Utente utente) {
        try {
            TypedQuery<Tessera> query = entityManager.createQuery(
                    "SELECT t FROM Tessera t WHERE t.utenteTesserato = :utente", Tessera.class);
            query.setParameter("utente", utente);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public void deleteById(UUID id) {

        Tessera daEliminare= this.findById(id);

        EntityTransaction et=entityManager.getTransaction();

        et.begin();

        entityManager.remove(daEliminare);

        et.commit();

        System.out.println("Libro " + daEliminare + " è stato eliminato");
    }

    public void renewalById(UUID id){

        Tessera daRinnovare= this.findById(id);

        if (daRinnovare.getDataRinnovo()==null){
            if (LocalDate.now().isAfter(daRinnovare.getDataEmissione().plusYears(1))){
                daRinnovare.setDataRinnovo(LocalDate.now());
            }
            else {
            System.out.println("La tessera " + daRinnovare + " è ancora valida");
            }
        }
        else if (LocalDate.now().isAfter(daRinnovare.getDataRinnovo().plusYears(1))){
            daRinnovare.setDataRinnovo(LocalDate.now());
        }
        else {
            System.out.println("Il rinnovo della tessera " + daRinnovare + " è ancora valido");
        }
    }


}
