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
        TessereDAO ted = new TessereDAO(em);

        Tratta t1 = new Tratta("milano", "malpensa", 213.4);
        Tratta t2 = new Tratta("milano", "linate", 155.4);

        List<Tratta> listaTratte = new ArrayList<>();
        listaTratte.add(t1);
        listaTratte.add(t2);

        System.out.println("Ciao, decidi quale utente sei");
        System.out.println("1)Passeggero");
        System.out.println("2)Amministratore");

        do {
            scelta = in.nextInt();
            in.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Benvenuto nell'azienda trasporti!");
                    System.out.println("Scegli un operazione dal menù, premi 0 per uscire.");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("1) Crea un titolo di viaggio");
                    System.out.println("2) Ho già un titolo di viaggio, mostrami gli orari!");
                    scelta = in.nextInt();
                    in.nextLine();

                    switch (scelta) {
                        case 1:
                            System.out.println("Da che punto vendita vuoi acquistarlo? Inserisci matricola:");
                            String matricola = in.nextLine();

                            if (pd.findById(UUID.fromString(matricola)) != null) {
                                PuntoVendita byId = pd.findById(UUID.fromString(matricola));

                                if (byId instanceof RivenditoreAutorizzato
                                        && ((RivenditoreAutorizzato) byId).getOrarioApertura().isBefore(LocalTime.now())
                                        && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isAfter(LocalTime.now())) {

                                    System.out.println("Che titolo vuoi acquistare?");
                                    System.out.println("1) Biglietto singolo");
                                    System.out.println("2) Abbonamento");
                                    System.out.println("3) Tessera");
                                    scelta = in.nextInt();
                                    in.nextLine();

                                    switch (scelta) {
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
                                                } while (scelta < 3 && scelta > 0);

                                            } else {
                                                System.out.println("La Tessera " + numeroTessera + " è inesistente!");
                                                System.out.println("Vuoi creare una nuova tessera?");
                                                System.out.println("1) Si, mostrami come fare!");
                                                System.out.println("2) No, non mi interessa grazie!");

                                                scelta = in.nextInt();
                                                in.nextLine();

                                                switch (scelta) {
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
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Bene! Proseguiamo con la creazione della tessera:");
                                            System.out.println("Inserisci il codice della tua carta d'identità!");
                                            String cartaIdentita;
                                            do {
                                                cartaIdentita = in.nextLine();
                                                if (ud.findById(UUID.fromString(cartaIdentita)) == null) {
                                                    System.out.println("Carta d'identità inesistente! Riprova:");
                                                }
                                            } while (ud.findById(UUID.fromString(cartaIdentita)) == null);

                                            ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                            break;
                                    }
                                }
                                else if (byId instanceof RivenditoreAutorizzato
                                        && ((RivenditoreAutorizzato) byId).getOrarioApertura().isAfter(LocalTime.now())
                                        && ((RivenditoreAutorizzato) byId).getOrarioChiusura().isBefore(LocalTime.now())) {
                                    System.out.println("Il rivenditore è chiuso!!!");
                                }
                                else if (byId instanceof DistributoreAutomatico &&
                                        ((DistributoreAutomatico) byId).getStatoDistributore()==StatoDistributore.ATTIVO){
                                    System.out.println("Che titolo vuoi acquistare?");
                                    System.out.println("1) Biglietto singolo");
                                    System.out.println("2) Abbonamento");
                                    System.out.println("3) Tessera");
                                    scelta = in.nextInt();
                                    in.nextLine();

                                    switch (scelta) {
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
                                                } while (scelta < 3 && scelta > 0);

                                            } else {
                                                System.out.println("La Tessera " + numeroTessera + " è inesistente!");
                                                System.out.println("Vuoi creare una nuova tessera?");
                                                System.out.println("1) Si, mostrami come fare!");
                                                System.out.println("2) No, non mi interessa grazie!");

                                                scelta = in.nextInt();
                                                in.nextLine();

                                                switch (scelta) {
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
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Bene! Proseguiamo con la creazione della tessera:");
                                            System.out.println("Inserisci il codice della tua carta d'identità!");
                                            String cartaIdentita;
                                            do {
                                                cartaIdentita = in.nextLine();
                                                if (ud.findById(UUID.fromString(cartaIdentita)) == null) {
                                                    System.out.println("Carta d'identità inesistente! Riprova:");
                                                }
                                            } while (ud.findById(UUID.fromString(cartaIdentita)) == null);

                                            ted.save(new Tessera(LocalDate.now(), null, ud.findById(UUID.fromString(cartaIdentita))));
                                            break;
                                    }

                                }
                            }
                            else System.out.println("distributore chiuso");
                            break;

                        case 2:
                            System.out.println("Questa è la lista delle tratte disponibili:");
                            listaTratte.forEach(tratta -> System.out.println("\n" + tratta));
                            break;
                    }
                    break;
            }

        } while (scelta != 0);

        em.close();
        emf.close();
    }
}
