package daviderocca;

import daviderocca.DAO.*;
import daviderocca.entities.*;
import daviderocca.enums.StatoDistributore;
import daviderocca.enums.StatoMezzo;
import daviderocca.enums.TipologiaMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");
    public static void main(String[] args) {


        EntityManager em = emf.createEntityManager();

        TitoliDiViaggioDAO td = new TitoliDiViaggioDAO(em);
        PuntiVenditaDAO pd = new PuntiVenditaDAO(em);
        MezziDiTrasportoDAO md = new MezziDiTrasportoDAO(em);
        StoricoPercorrenzeDAO sp = new StoricoPercorrenzeDAO(em);
        UtentiDAO ut = new UtentiDAO(em);
        TessereDAO ts = new TessereDAO(em);

//        Biglietto b=new Biglietto(LocalDate.of(2025,4,3),LocalDate.of(2025,4,6));
//
//        MezzoDiTrasporto mz1 = new MezzoDiTrasporto(12, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        MezzoDiTrasporto mz2 = new MezzoDiTrasporto(342, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//
//        Tratta t1 = new Tratta("milano", "malpensa", 213.4);
//        Tratta t2 = new Tratta("milano", "linate", 155.4);
//
//        md.save(mz1);
//        md.save(mz2);
//
//        md.save(t1);
//        md.save(t2);
//
//        sp.assegnaTrattaAlMezzo(mz1, t1, 231.6);
//        sp.assegnaTrattaAlMezzo(mz2, t2, 148.9);
//        sp.assegnaTrattaAlMezzo(mz1, t2, 213.4);
//
//        MezzoDiTrasporto mezzo1Trovato = md.findMezzoById(UUID.fromString("6c401cbf-782b-4b55-ab7f-a5ff4e77e651"));
//        Tratta tratta1Trovato = md.findTrattaById(UUID.fromString("cb6049b8-9fbd-4231-abd5-d0e5c22728b8"));
//
//        sp.assegnaTrattaAlMezzo(mezzo1Trovato, tratta1Trovato, 251.6);
//
//        sp.numeroVolteMezzoTratta(mezzo1Trovato, tratta1Trovato);
//
//        sp.mediaTempoEffettivo(mezzo1Trovato, tratta1Trovato);

//        RivenditoreAutorizzato r1= new RivenditoreAutorizzato("via Verdi 32", LocalTime.of(13, 00), LocalTime.of(18, 30));
//
//        pd.savePuntoVendita(r1);
//
//        PuntoVendita negozioTrovato = pd.findById(UUID.fromString("08f9fa7b-6732-47c2-b413-30cc0a708e0b"));
//        System.out.println("Il punto vendita cercato si trova all'indirizzo " + negozioTrovato.getIndirizzo());

//        td.save(b);


//        Utente u1= new Utente(LocalDate.of(1993, 4, 12), "Rossi", "Mario");
//        ut.save(u1);
//
//        Tessera ts1=new Tessera(LocalDate.of(2025, 5, 12), null, u1);
//        ts.save(ts1);



        em.close();
        emf.close();

    }
}
