package borislavk.DAO;

import borislavk.entities.*;
import borislavk.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MezziDiTrasportoDAO {
    private final EntityManager entityManager;

    public MezziDiTrasportoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(MezzoDiTrasporto mezzoDiTrasporto) {

        EntityTransaction et = entityManager.getTransaction();

        et.begin();

        entityManager.persist(mezzoDiTrasporto);

        et.commit();

        System.out.println("il mezzo di trasporto " + mezzoDiTrasporto + " è stato correttamente salvato");

    }

    public void save(Tratta tratta) {

        EntityTransaction et = entityManager.getTransaction();

        et.begin();

        entityManager.persist(tratta);

        et.commit();

        System.out.println("La tratta da" + tratta.getPartenza() + " a " + tratta.getArrivo() +" è stata correttamente salvata");

    }

    public void saveGuasto(GuastoMezzo guasto) {

        EntityTransaction et = entityManager.getTransaction();

        et.begin();

        entityManager.persist(guasto);

        et.commit();

        System.out.println("Il guasto" + guasto.getId() +" è stato correttamente salvato");

    }


    public MezzoDiTrasporto findMezzoById(UUID id){

        MezzoDiTrasporto trovato=entityManager.find(MezzoDiTrasporto.class,id);
        if(trovato==null)
            throw new NotFoundException(id);

        return trovato;

    }

    public Tratta findTrattaById(UUID id){

        Tratta trovato=entityManager.find(Tratta.class,id);
        if(trovato==null)
            throw new NotFoundException(id);

        return trovato;

    }

    public  void deleteById(UUID id){
        MezzoDiTrasporto daEliminare=this.findMezzoById(id);
        EntityTransaction et=entityManager.getTransaction();
        et.begin();
        entityManager.remove(daEliminare);
        et.commit();

        System.out.println("il mezzo di trasporto "+daEliminare+" è stato eliminato");

    }

    public List<GuastoMezzo> findByPeriod(LocalDate a , LocalDate b, UUID id) {
        TypedQuery<GuastoMezzo> query = entityManager.createQuery(
                "SELECT g FROM GuastoMezzo g WHERE g.mezzoDiTrasporto.id = :id AND g.dataDiGuasto >= :a AND g.dataDiRitornoInServizio <= :b",
                GuastoMezzo.class
        );

        query.setParameter("a", a);
        query.setParameter("b", b);
        query.setParameter("id", id);

        List<GuastoMezzo> guasti = query.getResultList();

        System.out.println("La lista dei guasti per il mezzo " + id + " è: " + guasti);

        return guasti;
    }

    public List<Tratta> getAllTratte() {
        return entityManager.createQuery("SELECT t FROM Tratta t", Tratta.class).getResultList();
    }

    public List<MezzoDiTrasporto> getAllMezzi() {
        return entityManager.createQuery("SELECT m FROM MezzoDiTrasporto", MezzoDiTrasporto.class).getResultList();
    }


}
