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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
        UtentiDAO ud = new UtentiDAO(em);
        TessereDAO ted=new TessereDAO(em);

//        Tratta t1 = new Tratta("milano", "malpensa", 213.4);
//        Tratta t2 = new Tratta("milano", "linate", 155.4);
////
//        MezzoDiTrasporto mz1 = new MezzoDiTrasporto(12, 11, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        MezzoDiTrasporto mz2 = new MezzoDiTrasporto(342, 342, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//
//        MezzoDiTrasporto mezzo1Trovato = md.findMezzoById(UUID.fromString("51d69b36-5a5c-46fe-abed-041d14417806"));
//        MezzoDiTrasporto mezzo2Trovato = md.findMezzoById(UUID.fromString("f4580095-fc94-4ad6-ada2-250552d305c5"));
//
//        Tratta tratta1Trovato = md.findTrattaById(UUID.fromString("4bb02cb3-cc96-4aef-87a7-8b90ec5aeed0"));
//        Tratta tratta2Trovato = md.findTrattaById(UUID.fromString("cb6049b8-9fbd-4231-abd5-d0e5c22728b8"));

//        sp.assegnaTrattaAlMezzo(mezzo1Trovato, tratta1Trovato, 34.5);
//        sp.assegnaTrattaAlMezzo(mezzo2Trovato, tratta2Trovato, 40.5);
//        sp.assegnaTrattaAlMezzo(mezzo1Trovato, tratta2Trovato, 41.5);
//
//        md.save(mz1);
//        md.save(mz2);

        List<Tratta> listaTratte = md.getAllTratte();

//        RivenditoreAutorizzato r1 = new RivenditoreAutorizzato("via Verdi 32", LocalTime.of(13, 00), LocalTime.of(18, 30));
//        pd.savePuntoVendita(r1);
//
//        RivenditoreAutorizzato r2 = new RivenditoreAutorizzato("piazza Gramsci 5", LocalTime.of(9, 00), LocalTime.of(13, 30));
//        pd.savePuntoVendita(r2);
//
//        RivenditoreAutorizzato r3 = new RivenditoreAutorizzato("via dai Mille 2", LocalTime.of(9, 00), LocalTime.of(19, 30));
//        pd.savePuntoVendita(r3);
//
//        RivenditoreAutorizzato r4 = new RivenditoreAutorizzato("via Nazionale 32", LocalTime.of(7, 30), LocalTime.of(17, 30));
//        pd.savePuntoVendita(r4);
//
//        RivenditoreAutorizzato r5 = new RivenditoreAutorizzato("corso Buenos Aires", LocalTime.of(10, 00), LocalTime.of(20, 30));
//        pd.savePuntoVendita(r5);
//
//        RivenditoreAutorizzato r6 = new RivenditoreAutorizzato("corso Mazzini 71", LocalTime.of(9, 00), LocalTime.of(20, 30));
//        pd.savePuntoVendita(r6);
//
//        RivenditoreAutorizzato r7 = new RivenditoreAutorizzato("via Mascagni 32", LocalTime.of(11, 00), LocalTime.of(22, 00));
//        pd.savePuntoVendita(r7);
//
//        RivenditoreAutorizzato r8 = new RivenditoreAutorizzato("via del Corso", LocalTime.of(10, 00), LocalTime.of(17, 30));
//        pd.savePuntoVendita(r8);
//
//        RivenditoreAutorizzato r9 = new RivenditoreAutorizzato("via Vecchi 19", LocalTime.of(9, 00), LocalTime.of(16, 30));
//        pd.savePuntoVendita(r9);
//
//        RivenditoreAutorizzato r10 = new RivenditoreAutorizzato("via Di Duccio 37", LocalTime.of(7, 00), LocalTime.of(19, 30));
//        pd.savePuntoVendita(r10);
//
//        RivenditoreAutorizzato r11 = new RivenditoreAutorizzato("piazza Matteotti", LocalTime.of(6, 00), LocalTime.of(18, 00));
//        pd.savePuntoVendita(r11);
//
//        RivenditoreAutorizzato r12 = new RivenditoreAutorizzato("via XX Settembre", LocalTime.of(8, 00), LocalTime.of(20, 00));
//        pd.savePuntoVendita(r12);
//
//        RivenditoreAutorizzato r13 = new RivenditoreAutorizzato("corso Telesio", LocalTime.of(7, 00), LocalTime.of(21, 30));
//        pd.savePuntoVendita(r13);

//        RivenditoreAutorizzato r14 = new RivenditoreAutorizzato("viale Monza", LocalTime.of(13, 00), LocalTime.of(23, 00));
//        pd.savePuntoVendita(r14);
//
//        RivenditoreAutorizzato r15 = new RivenditoreAutorizzato("piazza Duomo", LocalTime.of(17, 00), LocalTime.of(23, 30));
//        pd.savePuntoVendita(r15);


        System.out.println("Ciao, decidi quale utente sei");
        System.out.println("1)Passeggero");
        System.out.println("2)Amministratore");
        do {
            scelta = in.nextInt();
            in.nextLine();

            switch (scelta){
                case 1:
                    System.out.println("Benvenuto nell'azienda trasporti!");
                    System.out.println("Scegli un operazione dal menù, premi 0 per uscire.");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("1) Crea un titolo di viaggio");
                    System.out.println("2) Ho già un titolo di viaggio, mostrami le tratte disponibili!");
                    scelta = in.nextInt();
                    in.nextLine();

                                switch (scelta) {
                                    case 1:
                                        System.out.println("Da che punto vendita vuoi acquistarlo? Inserisci matricola:");
                                        String matricola = in.nextLine();
                                        //Controllo se la matricola inserita esista nel db
                                        if (pd.findById(UUID.fromString(matricola))!=null){
                                            //Se esiste dichiara un oggetto punto vendita
                                            PuntoVendita byId = pd.findById(UUID.fromString(matricola));

                                            //CASISTICA IN CUI IL PUNTO VEDITA è UN RIVENDITORE AUTORIZZATO ED è APERTO
                                            if(byId instanceof RivenditoreAutorizzato
                                                    && ((RivenditoreAutorizzato) byId).getOrarioApertura().isBefore(LocalTime.now() )
                                                    && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isAfter(LocalTime.now()))
                                            {   System.out.println("Che titolo vuoi acquistare?");
                                                System.out.println("1) Biglietto singolo");
                                                System.out.println("2) Abbonamento");
                                                System.out.println("3) Tessera");
                                                scelta=in.nextInt();
                                                in.nextLine();

                                                switch (scelta) {
                                                    case 1:
                                                        td.save(new Biglietto(LocalDate.now(), null));
                                                        break;
                                                    case 2:
                                                        System.out.println("Inserisci numero tessera");
                                                        String numeroTessera = in.nextLine();
                                                        //Controllo se la tessera esiste
                                                        if(ted.findById(UUID.fromString(numeroTessera))!= null)
                                                        {
                                                            //Qua verifica validità tessera ed eventualmente rinnova
                                                            ted.renewalById(UUID.fromString(numeroTessera));

                                                            System.out.println("Scegli la tipologia di abbonamento:");
                                                            System.out.println("1) Settimanale");
                                                            System.out.println("2) Mensile");


                                                            do {
                                                            scelta = in.nextInt();
                                                            in.nextLine();
                                                                switch (scelta) {
                                                                    case 1:
                                                                        td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.SETTIMANALE));
                                                                        break;

                                                                    case 2:
                                                                        td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.MENSILE));
                                                                        break;

                                                                    default:
                                                                        System.out.println("Scelta non valida, riprova! Unici valori accettabili sono 1 o 2!!");
                                                                }
                                                                      } while (!(scelta < 3 && scelta > 0));

                                                            } else {
                                                            System.out.println("La Tessera " + numeroTessera + " è inesistente!" );
                                                            System.out.println("Vuoi creare una nuova tessera?");

                                                            System.out.println("1) Si, mostrami come fare!");
                                                            System.out.println("2) No, non mi interessa grazie!");

                                                            scelta = in.nextInt();
                                                            in.nextLine();

                                                            switch (scelta) {
                                                                case 1:
                                                                    System.out.println("Inserisci il codice della tua carta d'identità" );

                                                                    // INSERIRE DOWILE PER VERIFICARE IL CORRETTO INSERIMENTO DEI DATI DELLA CARTA IDENTITà

                                                                    String cartaIdentita = in.nextLine();
                                                                    ud.findById(UUID.fromString(cartaIdentita));
                                                                    if (ud.findById(UUID.fromString(cartaIdentita)) != null) {
                                                                        ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                                                    }
                                                                    break;

                                                                case 2:
                                                                    System.out.println("Perfetto! Verrai indirizzato alla pagina dell'acquisto titoli di viaggio!");
                                                                    break;
                                                            }

                                                        }
                                                        break;

                                                    case 3:
                                                        System.out.println("Bene! Proseguiamo con la creazione della tessera:");
                                                            System.out.println("Inserisci il codice della tua carta d'identità!" );

                                                            // INSERIRE DOWILE PER VERIFICARE IL CORRETTO INSERIMENTO DEI DATI DELLA CARTA IDENTITà

                                                            String cartaIdentita = in.nextLine();

                                                            ud.findById(UUID.fromString(cartaIdentita));

                                                            if (ud.findById(UUID.fromString(cartaIdentita)) != null)
                                                            {ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                                            } else {
                                                                System.out.println("Carta d'identità inesistente! Contatta la nostra assistenza!");
                                                            }

                                                            break;


                                        }
                                        break;
                                } else if (byId instanceof RivenditoreAutorizzato
                                                    && ((RivenditoreAutorizzato) byId).getOrarioApertura().isAfter(LocalTime.now())
                                                    && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isBefore(LocalTime.now())) {
                                                System.out.println("Il rivenditore è chiuso!!!");
                                            }
                        }
                                        //----------------------------------------------LINEA DA NON SUPERARE------------------------------------------------------------------
                                    case 2:
                                        System.out.println("Questa è la lista delle tratte disponibili:");
                                        for (int i = 0; i < listaTratte.size(); i++) {
                                            System.out.println((i + 1) + ") " + listaTratte.get(i));
                                        }

                                        System.out.println("Quale tra queste scegli?");
                                        scelta = in.nextInt();
                                        in.nextLine();

                                        if(scelta < 1 || scelta > listaTratte.size()) {
                                            System.out.println("Scelta non valida!");
                                            //DA CAPIRE COME CONTINUARE
                                        } else {
                                            //DA VEDERE PER LA CAPIENZA
                                            Tratta trattaScelta = listaTratte.get(scelta - 1);

                                            List<MezzoDiTrasporto> mezziTrattaSelezionata = sp.getMezziByTratta(trattaScelta);

                                            if(mezziTrattaSelezionata.isEmpty()) {
                                                System.out.println("Nessun mezzo è associato a questa tratta!");
                                            }
                                            else {
                                                int sceltaMezzo;
                                                MezzoDiTrasporto mezzoScelto = null;
                                                do {
                                                    System.out.println("Ecco la lista di mezzi associati a questa tratta:");
                                                    LocalTime orarioDiPartenza = LocalTime.of(6, 0);
                                                    for (int i = 0; i < mezziTrattaSelezionata.size(); i++) {
                                                        LocalTime orarioMezzo = orarioDiPartenza.plusMinutes(i * 15);
                                                        System.out.println((i + 1) + ") " + mezziTrattaSelezionata.get(i) + " ||Orario: " + orarioMezzo);
                                                    }

                                                        System.out.println("\nQuale tra questi mezzi scegli? Inserisci un numero valido:");
                                                        sceltaMezzo = in.nextInt();
                                                        in.nextLine();

                                                        if(sceltaMezzo < 1 || sceltaMezzo > mezziTrattaSelezionata.size()) {
                                                            System.out.println("Scelta non valida, riprova!");
                                                            continue;
                                                        }

                                                        mezzoScelto = mezziTrattaSelezionata.get(sceltaMezzo - 1);

                                                        if (mezzoScelto.getNumeroPasseggeriAttuali() < mezzoScelto.getCapienzaMassima()) {
                                                            System.out.println("Benvenuto a bordo! Mi mostri il tuo titolo di viaggio? Inserisci l'id!");

                                                            String idTitoloUtente = in.nextLine();

                                                            if (td.findById(UUID.fromString(idTitoloUtente)) == null) {
                                                                System.out.println("Riprova!");
                                                            }

                                                            TitoloDiViaggio titoloUtente = td.findById(UUID.fromString(idTitoloUtente));

                                                            if (titoloUtente instanceof Biglietto) {
                                                                td.deleteById(UUID.fromString(idTitoloUtente));
                                                                System.out.println("Goditi pure il tuo viaggio verso " + trattaScelta.getArrivo() + "!");
                                                                } else if (titoloUtente instanceof Abbonamento){
                                                                if (((Abbonamento) titoloUtente).getTipoAbbonamento() == TipoAbbonamento.SETTIMANALE){
                                                                    LocalDate dataScadenzaAbbonamento = titoloUtente.getDataEmissione().plusDays(7);

                                                                    if(dataScadenzaAbbonamento.isAfter(LocalDate.now())) {
                                                                        System.out.println("Il tuo abbonamento è valido! Sali pure sul mezzo!");
                                                                    } else {
                                                                        System.out.println("Il tuo abbonamento non è valido, devi scendere!");
                                                                        scelta = 0;
                                                                    }
                                                                } else if (((Abbonamento) titoloUtente).getTipoAbbonamento() == TipoAbbonamento.MENSILE) {
                                                                    LocalDate dataScadenzaAbbonamento = titoloUtente.getDataEmissione().plusMonths(1);

                                                                    if(dataScadenzaAbbonamento.isAfter(LocalDate.now())) {
                                                                        System.out.println("Il tuo abbonamento è valido! Sali pure sul mezzo!");
                                                                    } else {
                                                                        System.out.println("Il tuo abbonamento non è valido, devi scendere!");
                                                                        scelta = 0;
                                                                    }
                                                                }
                                                            }

                                                        } else {
                                                            System.out.println("\nMezzo pieno! Scegli un altro mezzo!");
                                                            mezzoScelto = null;
                                                        }

                                                } while (mezzoScelto == null);
                                            }
                                        }

                                        break;
                                }

                    break;
            }

        } while (scelta!=0);



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
