package daviderocca;

import daviderocca.DAO.*;
import daviderocca.entities.*;
import daviderocca.enums.StatoDistributore;
import daviderocca.enums.StatoMezzo;
import daviderocca.enums.TipoAbbonamento;
import daviderocca.enums.TipologiaMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");
    public static void main(String[] args) {

        int scelta;
        Scanner in = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        TitoliDiViaggioDAO td = new TitoliDiViaggioDAO(em);
        PuntiVenditaDAO pd = new PuntiVenditaDAO(em);
        MezziDiTrasportoDAO md = new MezziDiTrasportoDAO(em);
        StoricoPercorrenzeDAO sp = new StoricoPercorrenzeDAO(em);
        TessereDAO ted=new TessereDAO(em);


        System.out.println("Ciao , decidi quale utente sei");
        System.out.println("1)Passeggero");
        System.out.println("2)Amministratore");
        do {
            scelta=in.nextInt();

            switch (scelta){
                case 1:
                    System.out.println("Benvenuto nell'azienda trasporti !");
                    System.out.println("Scegli un operazione dal menù , premi 0 per uscire.");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("1) Crea un titolo di viaggio");
                    scelta=in.nextInt();

                    System.out.println("Da che punto vendita vuoi acquistarlo? Inserisci matricola");
                    String matricola= in.nextLine();
                    if (pd.findById(UUID.fromString(matricola))!=null){

                    }


                    switch (scelta){
                        case 1:
                            System.out.println("Che titolo vuoi acquistare?");
                            System.out.println("1) Biglietto singolo");
                            System.out.println("2) Abbonamento");
                            System.out.println("3) Tessera");

                            scelta=in.nextInt();
                            switch (scelta){
                                case 1:
                                    td.save(new Biglietto(LocalDate.now(),null));
                                    break;
                                case 2:
                                    System.out.println("Inserisci numero tessera");
                                    String numeroTessera=in.nextLine();


                                    if (ted.findById(UUID.fromString(numeroTessera))!=null){



                                        System.out.println("Scegli la tipologia di abbonamento:");
                                        System.out.println("1) Settimanale");
                                        System.out.println("2)Mensile");

                                        scelta=in.nextInt();

                                        if(scelta==1)

                                            td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.SETTIMANALE));

                                        else
                                            td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.MENSILE));
                                    }





                            }

                    }



            }

        }while (scelta!=0);


        System.out.println("Benvenuto nell'azienda trasporti !");
        System.out.println("Scegli un operazione dal menù , premi 0 per uscire.");
        System.out.println("-----------------------------------------------------");
        System.out.println("1)");


//        MezzoDiTrasporto mz1 = new MezzoDiTrasporto(12, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        MezzoDiTrasporto mz2 = new MezzoDiTrasporto(342, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
////
//        Tratta t1 = new Tratta("milano", "malpensa", 213.4);
//        Tratta t2 = new Tratta("milano", "linate", 155.4);
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

//        MezzoDiTrasporto mezzo1Trovato = md.findMezzoById(UUID.fromString("6c401cbf-782b-4b55-ab7f-a5ff4e77e651"));
//        Tratta tratta1Trovato = md.findTrattaById(UUID.fromString("cb6049b8-9fbd-4231-abd5-d0e5c22728b8"));

        //sp.assegnaTrattaAlMezzo(mezzo1Trovato, tratta1Trovato, 251.6);

//        sp.numeroVolteMezzoTratta(mezzo1Trovato, tratta1Trovato);
//
//        sp.mediaTempoEffettivo(mezzo1Trovato, tratta1Trovato);






        em.close();
        emf.close();

    }
}
