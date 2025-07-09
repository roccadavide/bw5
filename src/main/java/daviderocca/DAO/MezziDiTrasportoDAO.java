package daviderocca.DAO;

import daviderocca.entities.GuastoMezzo;
import daviderocca.entities.MezzoDiTrasporto;
import daviderocca.entities.TitoloDiViaggio;
import daviderocca.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MezziDiTrasportoDAO {
    private EntityManager entityManager;

    public void save(MezzoDiTrasporto mezzoDiTrasporto) {

        EntityTransaction et = entityManager.getTransaction();
        et.begin();

        entityManager.persist(mezzoDiTrasporto);

        et.commit();

        System.out.println("il mezzo di trasporto "+mezzoDiTrasporto+" è stato correttamente salvato");

    }

    public MezzoDiTrasporto findById(UUID id){

        MezzoDiTrasporto trovato=entityManager.find(MezzoDiTrasporto.class,id);
        if(trovato==null)
            throw new NotFoundException(id);

        return trovato;

    }

    public  void deleteById(UUID id){
        MezzoDiTrasporto daEliminare=this.findById(id);
        EntityTransaction et=entityManager.getTransaction();
        et.begin();
        entityManager.remove(daEliminare);
        et.commit();

        System.out.println("il mezzo di trasporto "+daEliminare+" è stato eliminato");

    }

    public List<GuastoMezzo> findByPeriod(LocalDate a , LocalDate b, UUID id){
        TypedQuery<GuastoMezzo> query= entityManager.createQuery
                ("SELECT g FROM GuastoMezzo g WHERE g.mezzoDiTrasporto.id_mezzo=:id AND g.dataGuasto >= :a AND g.dataRientro <= :b",GuastoMezzo.class);
        query.setParameter("a",a);
        query.setParameter("b",b);
        query.setParameter("id",id);


        return query.getResultList();
    }

}
