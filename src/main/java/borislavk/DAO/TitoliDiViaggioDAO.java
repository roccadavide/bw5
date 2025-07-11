package borislavk.DAO;

import borislavk.entities.TitoloDiViaggio;
import borislavk.entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TitoliDiViaggioDAO {

    private final EntityManager entityManager;

    public TitoliDiViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {

        EntityTransaction et = entityManager.getTransaction();
        et.begin();

        entityManager.persist(titoloDiViaggio);

        et.commit();

        System.out.println("il titolo di viaggio è stato correttamente salvato, inserisci l'id quando richiesto -->" + titoloDiViaggio.getIdTitolo());

    }

    public TitoloDiViaggio findById(UUID id){

        TitoloDiViaggio trovato = entityManager.find(TitoloDiViaggio.class, id);
        if(trovato==null)
            System.out.println("il titolo di viaggio " + trovato + " non è stato trovato");

        return trovato;
    }

    public  void deleteById(UUID id) {

        TitoloDiViaggio daEliminare = this.findById(id);

        EntityTransaction et=entityManager.getTransaction();

        et.begin();

        entityManager.remove(daEliminare);

        et.commit();

        System.out.println("il titolo di viaggio " + daEliminare + " è stato eliminato");

    }

    public long countTitoliByPeriodAndPuntoVendita(LocalDate a, LocalDate b, UUID idPuntoVendita) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(t) FROM TitoloDiViaggio t WHERE t.dataEmissione BETWEEN :a AND :b AND t.puntoVendita.id = :idPuntoVendita",
                Long.class);

        query.setParameter("a", a);
        query.setParameter("b", b);
        query.setParameter("idPuntoVendita", idPuntoVendita);
        long count = query.getSingleResult();

        System.out.println("Numero di titoli venduti: " + count);

        return count;
    }


    public void findTicketByTransport(UUID idMezzo) {
        TypedQuery<Long> query= entityManager.createQuery
                ("SELECT COUNT (t) from TitoloDiViaggio t WHERE t.id_mezzo = :idMezzo",Long.class);

        query.setParameter("id_mezzo", idMezzo);

        Long count = query.getSingleResult();

        System.out.println("Il numero di biglietti vidimati per il mezzo " + idMezzo + " è uguale a: " + count);
    }

    public void findTicketByPeriod(LocalDate a , LocalDate b){
        TypedQuery <Long> query= entityManager.createQuery
                ("SELECT COUNT (t) from TitoloDiViaggio t WHERE t.dataObliterazione BETWEEN :a AND :b", Long.class);
        query.setParameter("a",a);
        query.setParameter("b",b);

        Long count= query.getSingleResult();

        System.out.println("Il numero di biglietti vidimati per il periodo " + a + "/ " + b +" è uguale a: " + count);

    }

    public List<Tratta> getAllTratte() {
        return entityManager.createQuery("SELECT t FROM Tratta t", Tratta.class).getResultList();
    }

}