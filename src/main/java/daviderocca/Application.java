package daviderocca;

import daviderocca.dao.PuntiVenditaDAO;
import daviderocca.entities.PuntoVendita;
import daviderocca.entities.enums.StatoPuntoVendita;
import daviderocca.entities.enums.TipologiaVendita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PuntiVenditaDAO pd= new PuntiVenditaDAO(em);

       

        em.close();
        emf.close();

    }
}
