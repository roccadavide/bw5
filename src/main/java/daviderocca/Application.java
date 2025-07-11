package daviderocca;

import daviderocca.DAO.*;
import daviderocca.entities.*;
import daviderocca.enums.StatoDistributore;
import daviderocca.enums.StatoMezzo;
import daviderocca.enums.TipoAbbonamento;
import daviderocca.enums.TipologiaMezzo;
import daviderocca.exceptions.InvalidUUIDFormat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw5pu");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        TitoliDiViaggioDAO td = new TitoliDiViaggioDAO(em);
        PuntiVenditaDAO pd = new PuntiVenditaDAO(em);
        MezziDiTrasportoDAO md = new MezziDiTrasportoDAO(em);
        StoricoPercorrenzeDAO sp = new StoricoPercorrenzeDAO(em);
        UtentiDAO ud = new UtentiDAO(em);
        TessereDAO ted = new TessereDAO(em);

        //UTENTI
//        Utente u1= new Utente(LocalDate.of(1993, 4, 12), "Rossi", "Mario");
//        ud.save(u1);
//
//        Utente u2= new Utente(LocalDate.of(1975, 10, 18), "Mascagni", "Pietro");
//        ud.save(u2);
//
//        Utente u3= new Utente(LocalDate.of(1957, 11, 25), "Sebastiani", "Amedeo");
//        ud.save(u3);
//
//        Utente u4= new Utente(LocalDate.of(2006, 1, 6), "Giolitti", "Giovanni");
//        ud.save(u4);
//
//        Utente u5= new Utente(LocalDate.of(1982, 5, 9), "Berlinguer", "Enrico");
//        ud.save(u5);
//
//        Utente u6= new Utente(LocalDate.of(1997, 8, 2), "Iotti", "Nilde");
//        ud.save(u6);
//
//        Utente u7= new Utente(LocalDate.of(1937, 4, 19), "Moro", "Aldo");
//        ud.save(u7);
//
//        Utente u8= new Utente(LocalDate.of(1979, 2, 28), "Alberti", "Leone");
//        ud.save(u8);
//
//        Utente u9= new Utente(LocalDate.of(2001, 9, 17), "Alberti", "Barbara");
//        ud.save(u9);
//
//        Utente u10= new Utente(LocalDate.of(1973, 4, 21), "Barbera", "Hanna");
//        ud.save(u10);
//
//        Utente u11= new Utente(LocalDate.of(2003, 12, 24), "Romanof", "Anastasia");
//        ud.save(u11);
//
//        Utente u12= new Utente(LocalDate.of(1990, 5, 1), "Romano", "Fabrizio");
//        ud.save(u12);
//
//        Utente u13= new Utente(LocalDate.of(1964, 10, 10), "Marini", "Valeria");
//        ud.save(u13);
//
//        Utente u14= new Utente(LocalDate.of(1987, 6, 21), "Fabrizi", "Valeria");
//        ud.save(u14);
//
//        Utente u15= new Utente(LocalDate.of(2007, 12, 28), "Marinelli", "Luca");
//        ud.save(u15);
//
//        Utente u16= new Utente(LocalDate.of(2010, 1, 24), "Marinetti", "Filippo Tommaso");
//        ud.save(u16);
//
//        Utente u17= new Utente(LocalDate.of(1976, 9, 18), "Tomasi", "Giuseppe");
//        ud.save(u17);
//
//        Utente u18= new Utente(LocalDate.of(1966, 12, 5), "Marinelli", "Luca");
//        ud.save(u18);
//
//        Utente u19= new Utente(LocalDate.of(1938, 11, 8), "Lucano", "Mimmo");
//        ud.save(u19);
//
//        Utente u20= new Utente(LocalDate.of(2000, 1, 1), "Tataranni", "Imma");
//        ud.save(u20);
//
//        Utente u21= new Utente(LocalDate.of(2015, 11, 13), "Mazzantini", "Margareth");
//        ud.save(u21);
//
//        Utente u22= new Utente(LocalDate.of(2004, 6, 28), "Carofiglio", "Gianrico");
//        ud.save(u22);
//
//        Utente u23= new Utente(LocalDate.of(1953, 5, 14), "Fenoglio", "Beppe");
//        ud.save(u23);
//
//        Utente u24= new Utente(LocalDate.of(1974, 3,17 ), "Morante", "Elsa");
//        ud.save(u24);
//
//        Utente u25= new Utente(LocalDate.of(2001, 10, 18), "Agnello", "Simonetta");
//        ud.save(u25);
//
//        Utente u26= new Utente(LocalDate.of(1965, 11, 12), "Murgia", "Michela");
//        ud.save(u26);
//
//        Utente u27= new Utente(LocalDate.of(1988, 2, 13), "Deledda", "Grazia");
//        ud.save(u27);
//
//        Utente u28= new Utente(LocalDate.of(1973, 3, 21), "Ferrante", "Elena");
//        ud.save(u28);
//
//        Utente u29= new Utente(LocalDate.of(1988, 1, 1), "Camilleri", "Andrea");
//        ud.save(u29);
//
//        Utente u30= new Utente(LocalDate.of(1936, 7, 31), "Pavese", "Cesare");
//        ud.save(u30);
//
//        Tessera ts1=new Tessera(LocalDate.of(2025, 5, 12), null, u1);
//        ted.save(ts1);
//
//        Tessera ts2=new Tessera(LocalDate.of(2012, 7, 7), LocalDate.of(2013, 7, 7), u2);
//        ted.save(ts2);
//
//        Tessera ts3=new Tessera(LocalDate.of(2008, 11, 3), LocalDate.of(2011, 12, 4), u3);
//        ted.save(ts3);
//
//        Tessera ts4=new Tessera(LocalDate.of(2017, 1, 28), LocalDate.of(2019, 5, 14), u4);
//        ted.save(ts4);
//
//        Tessera ts5=new Tessera(LocalDate.of(2008, 11, 3), LocalDate.of(2011, 12, 4), u5);
//        ted.save(ts5);
//
//        Tessera ts6=new Tessera(LocalDate.of(2020, 4, 16), LocalDate.of(2021, 4, 18), u6);
//        ted.save(ts6);
//
//        Tessera ts7=new Tessera(LocalDate.of(2019, 6, 13), LocalDate.of(2023, 9, 4), u7);
//        ted.save(ts7);
//
//        Tessera ts8=new Tessera(LocalDate.of(2021, 6, 30), LocalDate.of(2023, 8, 14), u8);
//        ted.save(ts8);
//
//        Tessera ts9=new Tessera(LocalDate.of(2012, 1, 13), LocalDate.of(2025, 6, 6), u9);
//        ted.save(ts9);
//
//        Tessera ts10=new Tessera(LocalDate.of(2007, 12, 1), LocalDate.of(2022, 9, 12), u10);
//        ted.save(ts10);
//
//        Tessera ts11=new Tessera(LocalDate.of(2010, 5, 22), LocalDate.of(2025, 6, 1), u11);
//        ted.save(ts11);
//
//        Tessera ts12=new Tessera(LocalDate.of(2016, 10, 10), LocalDate.of(2023, 1, 21), u12);
//        ted.save(ts12);
//
//        Tessera ts13=new Tessera(LocalDate.of(2021, 2, 1), null, u13);
//        ted.save(ts13);
//
//        Tessera ts14=new Tessera(LocalDate.of(2000, 6, 13), null, u14);
//        ted.save(ts14);
//
//        Tessera ts15=new Tessera(LocalDate.of(2024, 2, 13), null, u15);
//        ted.save(ts15);
//
//        Tessera ts16=new Tessera(LocalDate.of(2024, 6, 23), null, u16);
//        ted.save(ts16);
//
//        Tessera ts17=new Tessera(LocalDate.of(2022, 4, 5), null, u17);
//        ted.save(ts17);
//
//        Tessera ts18=new Tessera(LocalDate.of(2023, 10, 31), null, u18);
//        ted.save(ts18);
//
//        Tessera ts19=new Tessera(LocalDate.of(2022, 8, 1), null, u19);
//        ted.save(ts19);
//
//        Tessera ts20=new Tessera(LocalDate.of(2018, 1, 7), null, u20);
//        ted.save(ts20);
//
//
//        //RIVENDITORE AUTORIZZATO
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
//
//        RivenditoreAutorizzato r14 = new RivenditoreAutorizzato("viale Monza", LocalTime.of(13, 00), LocalTime.of(23, 00));
//        pd.savePuntoVendita(r14);
//
//        RivenditoreAutorizzato r15 = new RivenditoreAutorizzato("piazza Duomo", LocalTime.of(17, 00), LocalTime.of(23, 30));
//        pd.savePuntoVendita(r15);
//
//
//        //DISTRIBUTORI AUTOMATICI
//        DistributoreAutomatico d1 = new DistributoreAutomatico ("via Roma 13", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d1);
//
//        DistributoreAutomatico d2 = new DistributoreAutomatico ("via Dante", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d2);
//
//        DistributoreAutomatico d3 = new DistributoreAutomatico ("piazza del Campo", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d3);
//
//        DistributoreAutomatico d4 = new DistributoreAutomatico ("piazza San Marco", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d4);
//
//        DistributoreAutomatico d5 = new DistributoreAutomatico ("piazza Garibaldi", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d5);
//
//        DistributoreAutomatico d6 = new DistributoreAutomatico ("piazza Gae Aulenti", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d6);
//
//        DistributoreAutomatico d7 = new DistributoreAutomatico ("piazzale Michelangelo", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d7);
//
//        DistributoreAutomatico d8 = new DistributoreAutomatico ("viale Marconi", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d8);
//
//        DistributoreAutomatico d9 = new DistributoreAutomatico ("piazza Bilotti", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d9);
//
//        DistributoreAutomatico d10 = new DistributoreAutomatico ("piazza Kennedy", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d10);
//
//        DistributoreAutomatico d11 = new DistributoreAutomatico ("corso Cavour", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d11);
//
//        DistributoreAutomatico d12 = new DistributoreAutomatico ("via Aldo Moro", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d12);
//
//        DistributoreAutomatico d13 = new DistributoreAutomatico ("via Cesare Battisti", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d13);
//
//        DistributoreAutomatico d14 = new DistributoreAutomatico ("piazza IV Novembre", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d14);
//
//        DistributoreAutomatico d15 = new DistributoreAutomatico ("piazza Castello", StatoDistributore.ATTIVO);
//        pd.savePuntoVendita(d15);
//
//        DistributoreAutomatico d16 = new DistributoreAutomatico ("via Vittorio Veneto", StatoDistributore.FUORI_SERVIZIO);
//        pd.savePuntoVendita(d16);
//
//        DistributoreAutomatico d17 = new DistributoreAutomatico ("viale Regina Margerita", StatoDistributore.FUORI_SERVIZIO);
//        pd.savePuntoVendita(d17);
//
//        DistributoreAutomatico d18 = new DistributoreAutomatico ("viale Trieste", StatoDistributore.FUORI_SERVIZIO);
//        pd.savePuntoVendita(d18);
//
//        DistributoreAutomatico d19 = new DistributoreAutomatico ("via Monte Grappa", StatoDistributore.FUORI_SERVIZIO);
//        pd.savePuntoVendita(d19);
//
//        DistributoreAutomatico d20 = new DistributoreAutomatico ("corso Italia", StatoDistributore.FUORI_SERVIZIO);
//        pd.savePuntoVendita(d20);
//
//
//        //TRATTA
//
//        Tratta t1 = new Tratta("Milano Centrale", "Malpensa aeroporto", 213.4);
//        md.save(t1);
//
//        Tratta t2 = new Tratta("Milano Centrale", "Linate aeroporto", 151.0);
//        md.save(t2);
//
//        Tratta t3 = new Tratta("Milano Centrale", "Orio AL Serio aeroporto", 234.5);
//        md.save(t3);
//
//        Tratta t4 = new Tratta("Duomo", "San Siro stadio", 34.5);
//        md.save(t4);
//
//        Tratta t5 = new Tratta("Duomo", "Assago", 104.5);
//        md.save(t5);
//
//        Tratta t6 = new Tratta("Duomo", "Loreto", 23.0);
//        md.save(t6);
//
//        Tratta t7 = new Tratta("Duomo", "Precotto", 123.0);
//        md.save(t7);
//
//        Tratta t8 = new Tratta("Duomo", "Roh fiera", 203.0);
//        md.save(t8);
//
//        Tratta t9 = new Tratta("San Siro stadio", "Rho", 232.2);
//        md.save(t9);
//
//        Tratta t10 = new Tratta("San Siro stadio", "Bovisa", 125.4);
//        md.save(t10);
//
//
//        //MEZZI
//
//        MezzoDiTrasporto mz1 = new MezzoDiTrasporto(20, 11, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz1);
//
//        MezzoDiTrasporto mz2 = new MezzoDiTrasporto(20, 5,  StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz2);
//
//        MezzoDiTrasporto mz3 = new MezzoDiTrasporto(20, 20,  StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz3);
//
//        MezzoDiTrasporto mz4 = new MezzoDiTrasporto(20, 6,  StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz4);
//
//        MezzoDiTrasporto mz5 = new MezzoDiTrasporto(20, 16, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz5);
//
//        MezzoDiTrasporto mz6 = new MezzoDiTrasporto(20, 18, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz6);
//
//        MezzoDiTrasporto mz7 = new MezzoDiTrasporto(20, 20, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz7);
//
//        MezzoDiTrasporto mz8 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz8);
//
//        MezzoDiTrasporto mz9 = new MezzoDiTrasporto(20, 3,  StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz9);
//
//        MezzoDiTrasporto mz10 = new MezzoDiTrasporto(20, 11, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz10);
//
//        MezzoDiTrasporto mz11 = new MezzoDiTrasporto(20, 14, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz11);
//
//        MezzoDiTrasporto mz12 = new MezzoDiTrasporto(20, 13, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz12);
//
//        MezzoDiTrasporto mz13 = new MezzoDiTrasporto(20, 19, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz13);
//
//        MezzoDiTrasporto mz14 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz14);
//
//        MezzoDiTrasporto mz15 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz15);
//
//        MezzoDiTrasporto mz16 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz16);
//
//        MezzoDiTrasporto mz17 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz17);
//
//        MezzoDiTrasporto mz18 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz18);
//
//        MezzoDiTrasporto mz19 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz19);
//
//        MezzoDiTrasporto mz20 = new MezzoDiTrasporto(20, 0, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz20);
//
//        MezzoDiTrasporto mz21 = new MezzoDiTrasporto(27, 22, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz21);
//
//        MezzoDiTrasporto mz22 = new MezzoDiTrasporto(27, 19, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz22);
//
//        MezzoDiTrasporto mz23 = new MezzoDiTrasporto(27, 2, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz23);
//
//        MezzoDiTrasporto mz24 = new MezzoDiTrasporto(27, 0, StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz24);
//
//        MezzoDiTrasporto mz25 = new MezzoDiTrasporto(27, 15, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz25);
//
//        MezzoDiTrasporto mz26 = new MezzoDiTrasporto(27, 22, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz26);
//
//        MezzoDiTrasporto mz27 = new MezzoDiTrasporto(27, 25, StatoMezzo.IN_MANUTENZIONE, TipologiaMezzo.AUTOBUS);
//        md.save(mz27);
//
//        MezzoDiTrasporto mz28 = new MezzoDiTrasporto(27, 13, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.AUTOBUS);
//        md.save(mz28);
//
//        MezzoDiTrasporto mz29 = new MezzoDiTrasporto(27, 17, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz29);
//
//        MezzoDiTrasporto mz30 = new MezzoDiTrasporto(27, 9, StatoMezzo.IN_SERVIZIO, TipologiaMezzo.TRAM);
//        md.save(mz30);
//
//
//        //Tratta 1: Milano Centrale - Malpensa aeroporto
//        sp.assegnaTrattaAlMezzo(mz1, t1, 55.2);
//        sp.assegnaTrattaAlMezzo(mz2, t1, 43.1);
//        sp.assegnaTrattaAlMezzo(mz3, t1, 72.7);
//
//        //Tratta 2: Milano Centrale - Linate aeroporto
//        sp.assegnaTrattaAlMezzo(mz4, t2, 35.6);
//        sp.assegnaTrattaAlMezzo(mz5, t2, 48.8);
//        sp.assegnaTrattaAlMezzo(mz6, t2, 59.3);
//
//        //Tratta 3: Milano Centrale - Orio AL Serio aeroporto
//        sp.assegnaTrattaAlMezzo(mz7, t3, 66.1);
//        sp.assegnaTrattaAlMezzo(mz8, t3, 53.0);
//        sp.assegnaTrattaAlMezzo(mz9, t3, 77.5);
//
//        //Tratta 4: Duomo - San Siro stadio
//        sp.assegnaTrattaAlMezzo(mz10, t4, 24.3);
//        sp.assegnaTrattaAlMezzo(mz11, t4, 37.9);
//        sp.assegnaTrattaAlMezzo(mz12, t4, 41.7);
//
//        //Tratta 5: Duomo - Assago
//        sp.assegnaTrattaAlMezzo(mz13, t5, 58.6);
//        sp.assegnaTrattaAlMezzo(mz14, t5, 49.2);
//        sp.assegnaTrattaAlMezzo(mz15, t5, 34.1);
//
//        //Tratta 6: Duomo - Loreto
//        sp.assegnaTrattaAlMezzo(mz16, t6, 22.4);
//        sp.assegnaTrattaAlMezzo(mz17, t6, 18.5);
//        sp.assegnaTrattaAlMezzo(mz18, t6, 30.9);
//
//        //Tratta 7: Duomo - Precotto
//        sp.assegnaTrattaAlMezzo(mz19, t7, 67.3);
//        sp.assegnaTrattaAlMezzo(mz20, t7, 59.8);
//        sp.assegnaTrattaAlMezzo(mz21, t7, 72.0);
//
//        //Tratta 8: Duomo - Roh fiera
//        sp.assegnaTrattaAlMezzo(mz22, t8, 80.1);
//        sp.assegnaTrattaAlMezzo(mz23, t8, 66.6);
//        sp.assegnaTrattaAlMezzo(mz24, t8, 51.9);
//
//        //Tratta 9: San Siro stadio - Rho
//        sp.assegnaTrattaAlMezzo(mz25, t9, 74.2);
//        sp.assegnaTrattaAlMezzo(mz26, t9, 61.3);
//        sp.assegnaTrattaAlMezzo(mz27, t9, 48.5);
//
//        //Tratta 10: San Siro stadio - Bovisa
//        sp.assegnaTrattaAlMezzo(mz28, t10, 43.8);
//        sp.assegnaTrattaAlMezzo(mz29, t10, 38.4);
//        sp.assegnaTrattaAlMezzo(mz30, t10, 29.7);
//
//        GuastoMezzo g1 = new GuastoMezzo("Perdita olio motore", LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 12));
//        g1.setMezzoDiTrasporto(mz2);
//        md.saveGuasto(g1);
//
//        GuastoMezzo g2 = new GuastoMezzo("Usura pastiglie freni", LocalDate.of(2024, 12, 6), LocalDate.of(2024, 12, 6));
//        g2.setMezzoDiTrasporto(mz1);
//        md.saveGuasto(g2);
//
//        GuastoMezzo g3 = new GuastoMezzo("Perdita olio motore", LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 12));
//        g3.setMezzoDiTrasporto(mz2);
//        md.saveGuasto(g3);
//
//        GuastoMezzo g4 = new GuastoMezzo("Usura pastiglie freni", LocalDate.of(2024, 10, 16), LocalDate.of(2024, 10, 20));
//        g4.setMezzoDiTrasporto(mz14);
//        md.saveGuasto(g4);
//
//        GuastoMezzo g5 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.of(2023, 7, 21), LocalDate.of(2023, 7, 29));
//        g5.setMezzoDiTrasporto(mz17);
//        md.saveGuasto(g5);
//
//        GuastoMezzo g6 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 29));
//        g6.setMezzoDiTrasporto(mz2);
//        md.saveGuasto(g6);
//
//        GuastoMezzo g7 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.of(2022, 5, 19), LocalDate.of(2022, 5, 31));
//        g7.setMezzoDiTrasporto(mz25);
//        md.saveGuasto(g7);
//
//        GuastoMezzo g8 = new GuastoMezzo("Revisione motore", LocalDate.of(2019, 8, 11), LocalDate.of(2019, 8, 29));
//        g8.setMezzoDiTrasporto(mz1);
//        md.saveGuasto(g8);
//
//        GuastoMezzo g9 = new GuastoMezzo("Sostituzione iniettori", LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 9));
//        g9.setMezzoDiTrasporto(mz25);
//        md.saveGuasto(g9);
//
//        GuastoMezzo g10 = new GuastoMezzo("Revisione motore", LocalDate.of(2025, 1, 4), LocalDate.of(2025, 1, 11));
//        g10.setMezzoDiTrasporto(mz17);
//        md.saveGuasto(g10);
//
//        GuastoMezzo g11 = new GuastoMezzo("Sostituzione iniettori", LocalDate.of(2021, 11, 21), LocalDate.of(2021, 11, 29));
//        g11.setMezzoDiTrasporto(mz25);
//        md.saveGuasto(g11);
//
//        GuastoMezzo g12 = new GuastoMezzo("Problema alimentazione", LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 19));
//        g12.setMezzoDiTrasporto(mz18);
//        md.saveGuasto(g12);
//
//        GuastoMezzo g13 = new GuastoMezzo("Problema alimentazione", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 29));
//        g13.setMezzoDiTrasporto(mz14);
//        md.saveGuasto(g13);
//
//        GuastoMezzo g15 = new GuastoMezzo("Problema ai freni", LocalDate.now(), null);
//        g15.setMezzoDiTrasporto(mz15);
//        md.saveGuasto(g15);
//
//        GuastoMezzo g17 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.now(), null);
//        g17.setMezzoDiTrasporto(mz17);
//        md.saveGuasto(g17);
//
//        GuastoMezzo g18 = new GuastoMezzo("Controllo centralina", LocalDate.now(), null);
//        g18.setMezzoDiTrasporto(mz2);
//        md.saveGuasto(g18);
//
//        GuastoMezzo g19 = new GuastoMezzo("Controllo centralina", LocalDate.now(), null);
//        g19.setMezzoDiTrasporto(mz24);
//        md.saveGuasto(g19);
//
//        GuastoMezzo g20 = new GuastoMezzo("Problema alimentazione", LocalDate.now(), null);
//        g20.setMezzoDiTrasporto(mz19);
//        md.saveGuasto(g20);
//
//
//        GuastoMezzo g21 = new GuastoMezzo("Usura pastiglie freni", LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 18));
//        g21.setMezzoDiTrasporto(mz24);
//        md.saveGuasto(g21);
//
//        GuastoMezzo g22 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.of(2023, 2, 5), LocalDate.of(2023, 2, 10));
//        g22.setMezzoDiTrasporto(mz17);
//        md.saveGuasto(g22);
//
//        GuastoMezzo g23 = new GuastoMezzo("Sostituzione iniettori", LocalDate.of(2022, 7, 22), LocalDate.of(2022, 7, 27));
//        g23.setMezzoDiTrasporto(mz2);
//        md.saveGuasto(g23);
//
//        GuastoMezzo g24 = new GuastoMezzo("Problema alimentazione", LocalDate.of(2023, 5, 9), LocalDate.of(2023, 5, 16));
//        g24.setMezzoDiTrasporto(mz15);
//        md.saveGuasto(g24);
//
//        GuastoMezzo g25 = new GuastoMezzo("Rottura asse", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
//        g25.setMezzoDiTrasporto(mz19);
//        md.saveGuasto(g25);
//
//        GuastoMezzo g26 = new GuastoMezzo("Combustione spontanea", LocalDate.of(2024, 11, 11), LocalDate.of(2024, 11, 20));
//        g26.setMezzoDiTrasporto(mz24);
//        md.saveGuasto(g26);
//
//        GuastoMezzo g27 = new GuastoMezzo("Danni alla carrozzeria", LocalDate.of(2022, 4, 8), LocalDate.of(2022, 4, 13));
//        g27.setMezzoDiTrasporto(mz17);
//        md.saveGuasto(g27);



        List<Tratta> listaTratte = md.getAllTratte();

        int sceltaMenu =0;
        do {
            System.out.println("Ciao, decidi quale utente sei");

            int sceltaUtente = 0;
            do {
                System.out.println("1)Passeggero");
                System.out.println("2)Amministratore");
                try {
                    sceltaUtente = in.nextInt();
                    in.nextLine();

                } catch (InputMismatchException e) {
                    in.nextLine();
                    System.out.println("formato non valido");
                }
                if (sceltaUtente<1 || sceltaUtente >2){
                    System.out.println("Riprova" );
                }
            }while (sceltaUtente<1 || sceltaUtente >2);



            switch (sceltaUtente) {
                case 1:
                    System.out.println("Benvenuto nell'azienda trasporti!");
                    System.out.println("Scegli un operazione dal menù, premi 0 per uscire.");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("1) Crea un titolo di viaggio");
                    System.out.println("2) Ho già un titolo di viaggio, mostrami gli orari!");
                    sceltaMenu = in.nextInt();
                    in.nextLine();

                    switch (sceltaMenu) {
                        case 1:
                            System.out.println("Da che punto vendita vuoi acquistarlo? Inserisci matricola:");
                            String matricola = null;
                            try {
                                matricola = in.nextLine();
                                UUID uuid=UUID.fromString(matricola);


                            } catch (IllegalArgumentException e) {

                                throw new InvalidUUIDFormat(matricola);
                            }


                            if (pd.findById(UUID.fromString(matricola)) != null) {
                                PuntoVendita byId = pd.findById(UUID.fromString(matricola));

                                if (byId instanceof RivenditoreAutorizzato
                                        && ((RivenditoreAutorizzato) byId).getOrarioApertura().isBefore(LocalTime.now())
                                        && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isAfter(LocalTime.now())) {

                                    int sceltaTitolo;
                                    do {
                                        System.out.println("Che titolo vuoi acquistare?");

                                        System.out.println("1) Biglietto singolo");
                                        System.out.println("2) Abbonamento");
                                        System.out.println("3) Tessera");
                                        sceltaTitolo = in.nextInt();
                                        in.nextLine();

                                        switch (sceltaTitolo) {
                                            case 1:
                                                td.save(new Biglietto(LocalDate.now(), null));
                                                break;

                                            case 2:
                                                System.out.println("Inserisci numero tessera");
                                                String numeroTessera = in.nextLine();

                                                if (ted.findById(UUID.fromString(numeroTessera)) != null) {
                                                    ted.renewalById(UUID.fromString(numeroTessera));

                                                    System.out.println("Scegli la tipologia di abbonamento:");
                                                    System.out.println("1) Settimanale");
                                                    System.out.println("2) Mensile");

                                                    int sceltaAbbonamento;
                                                    do {
                                                        sceltaAbbonamento = in.nextInt();
                                                        in.nextLine();
                                                        switch (sceltaAbbonamento) {
                                                            case 1:
                                                                td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.SETTIMANALE));
                                                                break;
                                                            case 2:
                                                                td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.MENSILE));
                                                                break;
                                                            default:
                                                                System.out.println("Scelta non valida, riprova! Unici valori accettabili sono 1 o 2!!");
                                                        }
                                                        if (sceltaAbbonamento < 1 || sceltaAbbonamento > 2)
                                                            System.out.println("Scelta non valida , riprova");
                                                    } while (sceltaAbbonamento < 1 || sceltaAbbonamento > 2);

                                                } else {
                                                    System.out.println("La Tessera " + numeroTessera + " è inesistente!");
                                                    int sceltaTessera;
                                                    do {
                                                        System.out.println("Vuoi creare una nuova tessera?");
                                                        System.out.println("1) Si, mostrami come fare!");
                                                        System.out.println("2) No, non mi interessa grazie!");

                                                        sceltaTessera = in.nextInt();
                                                        in.nextLine();

                                                        switch (sceltaTessera) {
                                                            case 1:
                                                                System.out.println("Inserisci il codice della tua carta d'identità");
                                                                String cartaIdentita;
                                                                do {
                                                                    cartaIdentita = in.nextLine();
                                                                    if (ud.findById(UUID.fromString(cartaIdentita)) == null) {
                                                                        System.out.println("Il numero della carta di identità " + cartaIdentita + " è inesistente. Riprova:");
                                                                    }
                                                                } while (ud.findById(UUID.fromString(cartaIdentita)) == null);

                                                                ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                                                break;

                                                            case 2:
                                                                System.out.println("Perfetto! Verrai indirizzato alla pagina dell'acquisto titoli di viaggio!");
                                                                break;
                                                        }

                                                    } while (sceltaTessera < 1 || sceltaTessera > 2);

                                                }
                                                break;

                                            case 3:
                                                System.out.println("Bene! Proseguiamo con la creazione della tessera:");

                                                String cartaIdentita;


                                                Utente utente;
                                                UUID uuid;
                                                do {
                                                    System.out.println("Inserisci il codice della tua carta d'identità!");
                                                    cartaIdentita = in.nextLine();
                                                    uuid = UUID.fromString(cartaIdentita);
                                                    utente = ud.findById(uuid);

                                                    if (utente == null) {
                                                        System.out.println("Carta d'identità inesistente! Riprova:");
                                                    }
                                                } while (utente == null);

                                                if (ted.findByUtente(utente) != null) {
                                                    System.out.println("L'utente ha già una tessera");
                                                } else {
                                                    ted.save(new Tessera(LocalDate.now(), null, utente));
                                                }

                                                break;

                                        }
                                        if (sceltaTitolo < 1 || sceltaTitolo > 3)
                                            System.out.println("Scelta non valida, Riprova");

                                    } while (sceltaTitolo < 1 || sceltaTitolo > 3);

                                } else if (byId instanceof RivenditoreAutorizzato
                                        && ((RivenditoreAutorizzato) byId).getOrarioApertura().isAfter(LocalTime.now())
                                        && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isBefore(LocalTime.now())) {
                                    System.out.println("Il rivenditore è chiuso!!!");


                                } else if (byId instanceof DistributoreAutomatico &&
                                        ((DistributoreAutomatico) byId).getStatoDistributore() == StatoDistributore.ATTIVO) {
                                    int sceltaTitolo;
                                    do {
                                        System.out.println("Che titolo vuoi acquistare?");

                                        System.out.println("1) Biglietto singolo");
                                        System.out.println("2) Abbonamento");
                                        System.out.println("3) Tessera");
                                        sceltaTitolo = in.nextInt();
                                        in.nextLine();

                                        switch (sceltaTitolo) {
                                            case 1:
                                                td.save(new Biglietto(LocalDate.now(), null));
                                                break;

                                            case 2:
                                                System.out.println("Inserisci numero tessera");
                                                String numeroTessera = in.nextLine();

                                                if (ted.findById(UUID.fromString(numeroTessera)) != null) {
                                                    ted.renewalById(UUID.fromString(numeroTessera));

                                                    System.out.println("Scegli la tipologia di abbonamento:");
                                                    System.out.println("1) Settimanale");
                                                    System.out.println("2) Mensile");

                                                    int sceltaAbbonamento;
                                                    do {
                                                        sceltaAbbonamento = in.nextInt();
                                                        in.nextLine();
                                                        switch (sceltaAbbonamento) {
                                                            case 1:
                                                                td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.SETTIMANALE));
                                                                break;
                                                            case 2:
                                                                td.save(new Abbonamento(LocalDate.now(), TipoAbbonamento.MENSILE));
                                                                break;
                                                            default:
                                                                System.out.println("Scelta non valida, riprova! Unici valori accettabili sono 1 o 2!!");
                                                        }
                                                        if (sceltaAbbonamento < 1 || sceltaAbbonamento > 2)
                                                            System.out.println("Scelta non valida , riprova");
                                                    } while (sceltaAbbonamento < 1 || sceltaAbbonamento > 2);

                                                } else {
                                                    System.out.println("La Tessera " + numeroTessera + " è inesistente!");
                                                    int sceltaTessera;
                                                    do {
                                                        System.out.println("Vuoi creare una nuova tessera?");
                                                        System.out.println("1) Si, mostrami come fare!");
                                                        System.out.println("2) No, non mi interessa grazie!");

                                                        sceltaTessera = in.nextInt();
                                                        in.nextLine();

                                                        switch (sceltaTessera) {
                                                            case 1:
                                                                System.out.println("Inserisci il codice della tua carta d'identità");
                                                                String cartaIdentita;
                                                                do {
                                                                    cartaIdentita = in.nextLine();
                                                                    if (ud.findById(UUID.fromString(cartaIdentita)) == null) {
                                                                        System.out.println("Il numero della carta di identità " + cartaIdentita + " è inesistente. Riprova:");
                                                                    }
                                                                } while (ud.findById(UUID.fromString(cartaIdentita)) == null);

                                                                ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                                                break;

                                                            case 2:
                                                                System.out.println("Perfetto! Verrai indirizzato alla pagina dell'acquisto titoli di viaggio!");
                                                                break;
                                                        }

                                                    } while (sceltaTessera < 1 || sceltaTessera > 2);

                                                }
                                                break;

                                            case 3:
                                                System.out.println("Bene! Proseguiamo con la creazione della tessera:");

                                                String cartaIdentita;


                                                Utente utente;
                                                UUID uuid;
                                                do {
                                                    System.out.println("Inserisci il codice della tua carta d'identità!");
                                                    cartaIdentita = in.nextLine();
                                                    uuid = UUID.fromString(cartaIdentita);
                                                    utente = ud.findById(uuid);

                                                    if (utente == null) {
                                                        System.out.println("Carta d'identità inesistente! Riprova:");
                                                    }
                                                } while (utente == null);

                                                if (ted.findByUtente(utente) != null) {
                                                    System.out.println("L'utente ha già una tessera");
                                                } else {
                                                    ted.save(new Tessera(LocalDate.now(), null, utente));
                                                }

                                                break;

                                        }
                                        if (sceltaTitolo < 1 || sceltaTitolo > 3)
                                            System.out.println("Scelta non valida, Riprova");

                                    } while (sceltaTitolo < 1 || sceltaTitolo > 3);

                                }
                            } else System.out.println("Il distributore è chiuso");
                            break;

                        case 2:
                            System.out.println("Questa è la lista delle tratte disponibili:");
                            for (int i = 0; i < listaTratte.size(); i++) {
                                System.out.println((i + 1) + ") " + listaTratte.get(i));
                            }

                            System.out.println("Quale tra queste scegli?");
                            int sceltaTratta = in.nextInt();
                            in.nextLine();

                            if(sceltaTratta < 1 || sceltaTratta > listaTratte.size()) {
                                System.out.println("Scelta non valida!");
                                //DA CAPIRE COME CONTINUARE
                            } else {
                                //DA VEDERE PER LA CAPIENZA
                                Tratta trattaScelta = listaTratte.get(sceltaTratta - 1);

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
                                            LocalTime orarioMezzo = orarioDiPartenza.plusMinutes(i * 60);
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
                                                        sceltaMenu = 0;
                                                    }
                                                } else if (((Abbonamento) titoloUtente).getTipoAbbonamento() == TipoAbbonamento.MENSILE) {
                                                    LocalDate dataScadenzaAbbonamento = titoloUtente.getDataEmissione().plusMonths(1);

                                                    if(dataScadenzaAbbonamento.isAfter(LocalDate.now())) {
                                                        System.out.println("Il tuo abbonamento è valido! Sali pure sul mezzo!");
                                                        sceltaMezzo = 0;
                                                    } else {
                                                        System.out.println("Il tuo abbonamento non è valido, devi scendere!");
                                                        sceltaMenu = 0;
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
                    //amministratore
                case 2:
                    System.out.println("Ciao Amministratore, scegli che operazione effettuare!");
                    System.out.println("1) Ricava il numero di titoli di vendita in un periodo e un punto vendita definiti da te ");
                    System.out.println("2) Verifica lo stato di un veicolo in un periodo definito da te ");
                    System.out.println("3) Verifica il tempo medio di percorrenza di un mezzo per la sua tratta");
                    int sceltaAmministratore;
                    sceltaAmministratore=in.nextInt();
                    in.nextLine();

                    switch (sceltaAmministratore){
                        case 1:
                        System.out.println("inserisci periodo");
                        System.out.println("inserisci data a");
                        String dataA=in.nextLine();
                        System.out.println("inserisci data b");
                        String dataB=in.nextLine();
                        System.out.println("inserisci punto vendita");
                        String pv= in.nextLine();
                        td.countTitoliByPeriodAndPuntoVendita(LocalDate.parse(dataA),LocalDate.parse(dataB), UUID.fromString(pv));
                        break;
                        case 2:
                            System.out.println("inserisci periodo");
                            System.out.println("inserisci data a");
                            String dataInizio=in.nextLine();
                            System.out.println("inserisci data b");
                            String dataFine=in.nextLine();
                            System.out.println("inserisci id mezzo");
                            String mezzo= in.nextLine();
                            md.findByPeriod(LocalDate.parse(dataInizio),LocalDate.parse(dataFine), UUID.fromString(mezzo));
                        break;
                        case 3:
                            System.out.println("inserisci id mezzo");

                            String idMezzo=in.nextLine();
                            sp.mediaTempoEffettivo(UUID.fromString(idMezzo));
                            break;
                    }
                    break;
            }

        } while (sceltaMenu != 0);

        em.close();
        emf.close();
    }
}