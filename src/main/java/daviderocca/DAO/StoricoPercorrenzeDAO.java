package daviderocca.DAO;

import daviderocca.entities.MezzoDiTrasporto;
import daviderocca.entities.PuntoVendita;
import daviderocca.entities.StoricoPercorrenze;
import daviderocca.entities.Tratta;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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
                "SELECT COUNT(s) FROM StoricoPercorrenze s WHERE s.mezzoDiTrasporto = :mezzoDiTrasporto",
                Long.class);
        query.setParameter("mezzoDiTrasporto", mezzoDiTrasporto);
        query.setParameter("tratta", tratta);
        System.out.println("Il mezzo " + mezzoDiTrasporto.getId() + " è passato " + query.getSingleResult()
                + " dalla tratta " + tratta.getPartenza() + "-" + tratta.getArrivo());
    }

    public Double mediaTempoEffettivo(UUID idMezzo) {
        TypedQuery<Double> query = entityManager.createQuery(
                "SELECT AVG(s.tempoEffettivoTratta) FROM StoricoPercorrenze s WHERE s.mezzoDiTrasporto.id = :idMezzo",
                Double.class);
        query.setParameter("idMezzo", idMezzo);

        Double mediaTratta= query.getSingleResult();

        System.out.println("Il mezzo " + idMezzo+ " percorre mediamente la sua tratta in " + mediaTratta + " minuti");
    return mediaTratta;
    }
    public List<MezzoDiTrasporto> getMezziByTratta(Tratta tratta) {
        TypedQuery<MezzoDiTrasporto> query = entityManager.createQuery("SELECT s.mezzoDiTrasporto FROM StoricoPercorrenze s WHERE s.tratta = :tratta",
                MezzoDiTrasporto.class);
        query.setParameter("tratta", tratta);
        return query.getResultList();
    }

}
