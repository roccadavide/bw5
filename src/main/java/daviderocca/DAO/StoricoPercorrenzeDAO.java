package daviderocca.DAO;

import daviderocca.entities.MezzoDiTrasporto;
import daviderocca.entities.PuntoVendita;
import daviderocca.entities.StoricoPercorrenze;
import daviderocca.entities.Tratta;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.UUID;

public class StoricoPercorrenzeDAO {

    private final EntityManager entityManager;

    public StoricoPercorrenzeDAO(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    public void assegnaTrattaAlMezzo (MezzoDiTrasporto mezzoDiTrasporto, Tratta tratta, double tempoEffettivo) {

        EntityTransaction et = entityManager.getTransaction();

        et.begin();

        StoricoPercorrenze storicoPercorrenze = new StoricoPercorrenze(tempoEffettivo);

        storicoPercorrenze.setTratta(tratta);

        storicoPercorrenze.setMezzoDiTrasporto(mezzoDiTrasporto);

        entityManager.persist(storicoPercorrenze);

        et.commit();

        System.out.println("Tratta assegnata al mezzo!");
    }

    //CHIEDIAMO A RICCARDO SE HA SENSO
    public void numeroVolteMezzoTratta(MezzoDiTrasporto mezzoDiTrasporto, Tratta tratta) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(s) FROM StoricoPercorrenze s WHERE s.mezzoDiTrasporto = :mezzoDiTrasporto AND s.tratta = :tratta",
                Long.class);
        query.setParameter("mezzoDiTrasporto", mezzoDiTrasporto);
        query.setParameter("tratta", tratta);
        System.out.println("Il mezzo " + mezzoDiTrasporto.getId() + " è passato " + query.getSingleResult()
                + " dalla tratta " + tratta.getPartenza() + "-" + tratta.getArrivo());
    }

    public void mediaTempoEffettivo(MezzoDiTrasporto mezzoDiTrasporto, Tratta tratta) {
        TypedQuery<Double> query = entityManager.createQuery(
                "SELECT AVG(s.tempoEffettivoTratta) FROM StoricoPercorrenze s WHERE s.mezzoDiTrasporto = :mezzoDiTrasporto AND s.tratta = :tratta",
                Double.class);
        query.setParameter("mezzoDiTrasporto", mezzoDiTrasporto);
        query.setParameter("tratta", tratta);
        System.out.println("Il mezzo " + mezzoDiTrasporto.getId() + " percorre mediamente la tratta "
                + tratta.getPartenza() + "-" + tratta.getArrivo() + " in " + query.getSingleResult() + " minuti");
    }

}
