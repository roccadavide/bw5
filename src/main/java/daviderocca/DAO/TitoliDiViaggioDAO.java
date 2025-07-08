package daviderocca.DAO;

import daviderocca.entities.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class TitoliDiViaggioDAO {

    private EntityManager entityManager;

    public TitoliDiViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {

        EntityTransaction et = entityManager.getTransaction();
        et.begin();

        entityManager.persist(titoloDiViaggio);

        et.commit();

        System.out.println("il titolo di viaggio "+titoloDiViaggio+" è stato correttamente salvato");

    }

    public TitoloDiViaggio findById(int id){

        TitoloDiViaggio trovato=entityManager.find(TitoloDiViaggio.class,id);
        if(trovato==null)
            System.out.println("il titolo di viaggio "+trovato+" non è stato trovato");


        return trovato;

    }

    public  void deleteById(int id){
        TitoloDiViaggio daEliminare=this.findById(id);
        EntityTransaction et=entityManager.getTransaction();
        et.begin();
        entityManager.remove(daEliminare);
        et.commit();

        System.out.println("il titolo di viaggio "+daEliminare+" è stato eliminato");

    }

    public List<TitoloDiViaggio> findByTitleAndPeriod(LocalDate a , LocalDate b,int idPuntoVendita){
        TypedQuery <TitoloDiViaggio> query= entityManager.createQuery
                ("SELECT COUNT t from TitoloDiViaggio t WHERE data_emissione BETWEEN :a AND :b AND id_punto_vendita=:idPuntoVendita",TitoloDiViaggio.class);
        query.setParameter("a",a);
        query.setParameter("b",b);
        query.setParameter("idPuntoVendita",idPuntoVendita);

        return query.getResultList();
    }

}
