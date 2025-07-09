package daviderocca.DAO;

import daviderocca.entities.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    public List<TitoloDiViaggio> findEntryPointByTitleAndPeriod(LocalDate a , LocalDate b,int idPuntoVendita){
        TypedQuery <TitoloDiViaggio> query= entityManager.createQuery
                ("SELECT COUNT t from TitoloDiViaggio t WHERE data_emissione BETWEEN :a AND :b AND id_punto_vendita=:idPuntoVendita",TitoloDiViaggio.class);
        query.setParameter("a",a);
        query.setParameter("b",b);
        query.setParameter("idPuntoVendita",idPuntoVendita);

        return query.getResultList();
    }

    public void findTicketByTransport(UUID idMezzo){
        TypedQuery<Long> query= entityManager.createQuery
                ("SELECT COUNT (t) from TitoloDiViaggio t WHERE t.id_mezzo=:idMezzo",Long.class);
        query.setParameter("id_mezzo",idMezzo);

        Long count= query.getSingleResult();

        System.out.println("il numero di biglietti vidimati per il mezzo "+idMezzo+" è uguale a: "+count);
    }

    public void findTicketByPeriod(LocalDate a , LocalDate b){
        TypedQuery <Long> query= entityManager.createQuery
                ("SELECT COUNT (t) from TitoloDiViaggio t WHERE t.dataObliterazione BETWEEN :a AND :b",Long.class);
        query.setParameter("a",a);
        query.setParameter("b",b);

        Long count= query.getSingleResult();

        System.out.println("il numero di biglietti vidimati per il periodo "+a+"/ " +b+" è uguale a: "+count);

    }

}
