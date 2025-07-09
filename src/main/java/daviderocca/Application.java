package daviderocca;

import daviderocca.DAO.MezziDiTrasportoDAO;
import daviderocca.DAO.PuntiVenditaDAO;
import daviderocca.DAO.StoricoPercorrenzeDAO;
import daviderocca.DAO.TitoliDiViaggioDAO;
import daviderocca.entities.*;
import daviderocca.enums.StatoDistributore;
import daviderocca.enums.StatoMezzo;
import daviderocca.enums.TipologiaMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");
    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();

        TitoliDiViaggioDAO td = new TitoliDiViaggioDAO(em);
        PuntiVenditaDAO pd = new PuntiVenditaDAO(em);
        MezziDiTrasportoDAO md = new MezziDiTrasportoDAO(em);
        StoricoPercorrenzeDAO sp = new StoricoPercorrenzeDAO(em);

//        Biglietto b=new Biglietto(LocalDate.of(2025,4,3),LocalDate.of(2025,4,6));

        MezzoDiTrasporto mz1 = new MezzoDiTrasporto(12, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
        MezzoDiTrasporto mz2 = new MezzoDiTrasporto(342, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//
        Tratta t1 = new Tratta("milano", "malpensa", 213.4);
        Tratta t2 = new Tratta("milano", "linate", 155.4);
//
//        md.save(mz1);
//        md.save(mz2);
//
//        md.save(t1);
//        md.save(t2);
//
//          sp.assegnaTrattaAlMezzo(mz1, t1, 231.6);
//          sp.assegnaTrattaAlMezzo(mz2, t2, 148.9);
//          sp.assegnaTrattaAlMezzo(mz1, t2, 213.4);

        MezzoDiTrasporto mezzo1Trovato = md.findMezzoById(UUID.fromString("6c401cbf-782b-4b55-ab7f-a5ff4e77e651"));
        Tratta tratta1Trovato = md.findTrattaById(UUID.fromString("cb6049b8-9fbd-4231-abd5-d0e5c22728b8"));

        //sp.assegnaTrattaAlMezzo(mezzo1Trovato, tratta1Trovato, 251.6);

        sp.numeroVolteMezzoTratta(mezzo1Trovato, tratta1Trovato);

        sp.mediaTempoEffettivo(mezzo1Trovato, tratta1Trovato);





//        PuntoVendita negozioTrovato = pd.findById(UUID.fromString("f4e98108-8b83-4b8a-80f0-ed5f332984e6"));
//        System.out.println("Il punto vendita cercato è di tipo " + negozioTrovato.getTipologiaVendita() + " ed è " +negozioTrovato.getStatoPuntoVendita());

//        pd.deletePuntoVendita(pv1);
//        td.save(b);



        em.close();
        emf.close();

    }
}
