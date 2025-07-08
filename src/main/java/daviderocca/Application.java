package daviderocca;

import daviderocca.DAO.PuntiVenditaDAO;
import daviderocca.DAO.TitoliDiViaggioDAO;
import daviderocca.entities.Biglietto;
import daviderocca.entities.PuntoVendita;
import daviderocca.entities.enums.StatoPuntoVendita;
import daviderocca.entities.enums.TipologiaVendita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");
    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();

        TitoliDiViaggioDAO td= new TitoliDiViaggioDAO(em);
        PuntiVenditaDAO pd= new PuntiVenditaDAO(em);

        Biglietto b=new Biglietto(LocalDate.of(2025,4,3),LocalDate.of(2025,4,6));


        PuntoVendita pv1= new PuntoVendita(TipologiaVendita.DISTRIBUTORE_AUTOMATICO, StatoPuntoVendita.APERTO, "Via a" );

        pd.savePuntoVendita(pv1);

//        PuntoVendita negozioTrovato = pd.findById(UUID.fromString("f4e98108-8b83-4b8a-80f0-ed5f332984e6"));
//        System.out.println("Il punto vendita cercato è di tipo " + negozioTrovato.getTipologiaVendita() + " ed è " +negozioTrovato.getStatoPuntoVendita());

//        pd.deletePuntoVendita(pv1);
//        td.save(b);



        em.close();
        emf.close();

    }
}
