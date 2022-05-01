package Biblioteca;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        PopulareDinFisier populare =  PopulareDinFisier.getInstance();
        List<Autori> listaAutori = populare.citireDinFisier("Autori.csv");
        List<Cititori> listaCititori = populare.citireCititori("Cititori.csv");;
        Map<Autori, Carti> cartiCuAutori = new HashMap<>();
        int nrActiuni = 0;
        int nrHorror = 0;
        int nrBiografie = 0;
        int nrPoezie = 0;
        int nrScienceFiction = 0;
        int comanda;
        int ok = 1;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Horror h = new Horror();
        ScienceFiction s = new ScienceFiction();
        Poezie p = new Poezie();
        Biografie b = new Biografie();
        System.out.println("Bine ati venit la biblioteca noastra!");
        while (ok == 1) {
            System.out.println("Pentru a adauga o carte, tastati 1.");
            System.out.println("Pentru a vedea lista de carti ale unui autor, tastati 2.");
            System.out.println("Pentru a vedea lista de carti dintr-o sectiune, tastati 3.");
            System.out.println("Pentru a adauga un autor nou, tastati 4.");
            System.out.println("Pentru a crea un cont de cititor, tastati 5.");
            System.out.println("Pentru a imprumuta carti ca cititor, tastati 6.");
            System.out.println("Pentru a vizualiza toate cartile, impreuna cu autorii lor, tastati 7.");
            System.out.println("Pentru a vizualiza lista de carti imprumutate, tastati 8.");
            System.out.println("Pentru a iesi din program, tastati 9.");
            comanda = scanner.nextInt();
            switch (comanda) {
                case 1:
                    System.out.println("Tastati titlul cartii!");
                    String titlu = scanner.next();
                    System.out.println("Tastati numarul de pagini!");
                    int nrpag = scanner.nextInt();
                    System.out.println("Tastati data publicarii!(exp: 10 iulie 1999)");
                    String data = scanner.next();
                    Carti c = new Carti(nrpag, titlu, data);
                    System.out.println("Cine este autorul cartii?Este un autor existent(tasta 1) in lista noastra, sau unul nou(tasta 2)?");
                    int autor = scanner.nextInt();
                    if (autor == 1) {
                        if (listaAutori.size() == 0) {
                            System.out.println("Nu avem inca niciun autor, va rugam sa introduceti unul");
                            continue;
                        }
                        for (int i = 0; i < listaAutori.size(); i++) {
                            System.out.println(listaAutori.get(i).nume + " " + listaAutori.get(i).prenume + " - " + (i+1));
                        }
                        System.out.println("Selectati autorul(dupa pozitia sa):");
                        int selAutor = scanner.nextInt();
                        listaAutori.get(selAutor-1).addCarti(c);
                        c.autor = listaAutori.get(selAutor-1);
                        cartiCuAutori.put(listaAutori.get(selAutor-1), c);
                    } else if (autor == 2) {
                        System.out.println("Numele:");
                        String numeAut = scanner.next();
                        System.out.println("Prenumele:");
                        String prenumeAut = scanner.next();
                        System.out.println("Anul nasterii:");
                        int anNastere = scanner.nextInt();
                        Autori a = new Autori(anNastere, numeAut, prenumeAut);
                        a.addCarti(c);
                        c.autor = a;
                        listaAutori.add(a);
                        cartiCuAutori.put(a, c);
                        System.out.println("Cartea a fost adaugata cu succes!\n");
                    }

                    System.out.println("Pentru a adauga cartea unei sectiuni, apasati tasta care ii corespunde:");
                    System.out.println("Horror: Tasta 1");
                    System.out.println("Science fiction: Tasta 2");
                    System.out.println("Poezie: Tasta 3");
                    System.out.println("Biografie: Tasta 4");

                    int sect = scanner.nextInt();

                    switch (sect) {
                        case 1:
                            h.addCarti(c);
                            h.mesajSectiune();
                            nrHorror++;
                            String stringh = c.titlu + " - " + c.autor.nume + ' ' + c.autor.prenume + ", " + c.nrPagini + " pagini, publicata la data de " + c.dataPublicarii;
                            ScriereInFisier.scriereFisier(nrHorror,stringh,"Horror.csv");
                            break;
                        case 2:
                            s.addCarti(c);
                            s.mesajSectiune();
                            nrScienceFiction++;
                            String strings = c.titlu + " - " + c.autor.nume + ' ' + c.autor.prenume + ", " + c.nrPagini + " pagini, publicata la data de " + c.dataPublicarii;
                            ScriereInFisier.scriereFisier(nrScienceFiction,strings,"ScienceFiction.csv");
                            break;
                        case 3:
                            p.addCarti(c);
                            p.mesajSectiune();
                            nrPoezie++;
                            String stringp = c.titlu + " - " + c.autor.nume + ' ' + c.autor.prenume + ", " + c.nrPagini + " pagini, publicata la data de " + c.dataPublicarii;
                            ScriereInFisier.scriereFisier(nrPoezie,stringp,"Poezie.csv");
                            break;
                        case 4:
                            b.addCarti(c);
                            b.mesajSectiune();
                            nrBiografie++;
                            String stringb = c.titlu + " - " + c.autor.nume + ' ' + c.autor.prenume + ", " + c.nrPagini + " pagini, publicata la data de " + c.dataPublicarii;
                            ScriereInFisier.scriereFisier(nrBiografie,stringb,"Biografie.csv");
                            break;
                    }

                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"adaugare carte" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 2:
                    for (int i = 0; i < listaAutori.size(); i++) {
                        System.out.println(listaAutori.get(i).nume + " " + listaAutori.get(i).prenume + " - " + (i+1));
                    }
                    System.out.println("Selectati autorul(dupa pozitia sa):");
                    int selAutor = scanner.nextInt();
                    listaAutori.get(selAutor-1).afiseazaListaCarti();
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"Vizionarea cartilor unui autor" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 3:
                    System.out.println("Selectati sectiunea din care doriti sa vizionati cartile:");
                    System.out.println("Horror: Tasta 1");
                    System.out.println("Science fiction: Tasta 2");
                    System.out.println("Poezie: Tasta 3");
                    System.out.println("Biografie: Tasta 4");
                    int cartiSect = scanner.nextInt();
                    switch (cartiSect) {
                        case 1:
                            h.afisareListaCarti();
                            break;
                        case 2:
                            s.afisareListaCarti();
                            break;
                        case 3:
                            p.afisareListaCarti();
                            break;
                        case 4:
                            b.afisareListaCarti();
                            break;
                    }
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"vizionarea cartilor dintr-o sectiune" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 4:

                    System.out.println("Tastati anul nasterii:");
                    int anulNasterii = scanner.nextInt();
                    System.out.println("Tastati numele:");
                    String nume = scanner.next();
                    System.out.println("Tastati prenumele:");
                    String prenume = scanner.next();
                    Autori a = new Autori(anulNasterii, nume, prenume);
                    listaAutori.add(a);
                    System.out.println("Autorul a fost adaugat cu succes!\n");
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"adaugarea unui autor" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 5:
                    System.out.println("Introduceti username-ul:");
                    String username = scanner.next();
                    for (int i = 0; i < listaCititori.size(); i++) {
                        while (username == null ? listaCititori.get(i).username == null : username.equals(listaCititori.get(i).username)) {
                            System.out.println("Acest username exista deja! Introduceti alt nume.");
                            username = scanner.next();
                        }
                    }
                    System.out.println("Introduceti parola:");
                    String parola = scanner.next();
                    Cititori c1 = new Cititori(username, parola);
                    listaCititori.add(c1);
                    System.out.println("Inregistrarea a fost cu succes! Acum puteti sa va conectati pentru a imprumuta carti!");
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"crearea unui cont nou" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 6:
                    System.out.println("Mai intai trebuie sa va conectati.");
                    System.out.println("Introduceti username-ul pentru autentificare:");
                    String user = scanner.next();
                    int ok1 = 0;
                    int userCurent = 0;
                    for (int i = 0; i < listaCititori.size(); i++) {
                        if (user == null ? listaCititori.get(i).username == null : user.equals(listaCititori.get(i).username)) {
                            ok1 = 1;
                            userCurent = i;
                            break;
                        }
                    }
                    if (ok1 == 1) {
                        System.out.println("Introduceti parola:");
                        String par = scanner.next();
                        while (!(par == null ? listaCititori.get(userCurent).parola == null : par.equals(listaCititori.get(userCurent).parola))) {
                            System.out.println("Parola este gresita! Introduceti din nou");
                            par = scanner.next();
                        }
                        System.out.println("Autentificarea a avut succes!");
                        System.out.println("Din ce sectiune doriti sa imprumutati cartea?");
                        System.out.println("Horror: Tasta 1");
                        System.out.println("Science fiction: Tasta 2");
                        System.out.println("Poezie: Tasta 3");
                        System.out.println("Biografie: Tasta 4");
                        int sec = scanner.nextInt();

                        Carti carteDeImprumutat = null;
                        switch(sec){
                            case 1:
                                h.afisareListaCarti();
                                if(h.listaCarti.size() == 0) {
                                    break;
                                }
                                System.out.println("Selectati cartea pe care doriti sa o imprumutati dupa pozitia sa(prima este tasta 1, a doua este tasta 2, s.a.m.d)");
                                int carte = scanner.nextInt();
                                carteDeImprumutat = h.listaCarti.get(carte-1);
                                System.out.println("Cartea a fost rezervata! va asteptam la biblioteca noastra!");
                                break;
                            case 2:
                                s.afisareListaCarti();
                                if(s.listaCarti.size() == 0) {
                                    break;
                                }
                                System.out.println("Selectati cartea pe care doriti sa o imprumutati dupa pozitia sa(prima este tasta 1, a doua este tasta 2, s.a.m.d)");
                                int cartesf = scanner.nextInt();
                                carteDeImprumutat = s.listaCarti.get(cartesf-1);
                                System.out.println("Cartea a fost rezervata! va asteptam la biblioteca noastra!");

                                break;
                            case 3:
                                p.afisareListaCarti();
                                if(p.listaCarti.size() == 0) {
                                    break;
                                }
                                System.out.println("Selectati cartea pe care doriti sa o imprumutati dupa pozitia sa(prima este tasta 1, a doua este tasta 2, s.a.m.d)");
                                int cartep = scanner.nextInt();
                                carteDeImprumutat = p.listaCarti.get(cartep-1);
                                System.out.println("Cartea a fost rezervata! va asteptam la biblioteca noastra!");
                                break;
                            case 4:
                                b.afisareListaCarti();
                                if(b.listaCarti.size() == 0) {
                                    break;
                                }
                                System.out.println("Selectati cartea pe care doriti sa o imprumutati dupa pozitia sa(prima este tasta 1, a doua este tasta 2, s.a.m.d)");
                                int carteb = scanner.nextInt();
                                carteDeImprumutat = b.listaCarti.get(carteb-1);
                                System.out.println("Cartea a fost rezervata! va asteptam la biblioteca noastra!");
                                break;
                        }
                        listaCititori.get(userCurent).addCarti(carteDeImprumutat);


                    }
                    else {
                        System.out.println("Nu am putut gasi userul in baza noastra de date. Inregistrati-va mai intai!");
                        break;
                    }
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"imprumutarea unei carti" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 7:
                    Set<Autori> keys = cartiCuAutori.keySet();
                    for(Autori key: keys)
                        System.out.println(key.nume + ' ' + key.prenume + "- " + cartiCuAutori.get(key).titlu +'\n');
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"vizualizarea perechilor carti + autor" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 8:
                    System.out.println("Mai intai trebuie sa va conectati.");
                    System.out.println("Introduceti username-ul pentru autentificare:");
                    String user1 = scanner.next();
                    int ok2 = 0;
                    int userCurent1 = 0;
                    for (int i = 0; i < listaCititori.size(); i++) {
                        if (user1 == null ? listaCititori.get(i).username == null : user1.equals(listaCititori.get(i).username)) {
                            ok2 = 1;
                            userCurent1 = i;
                            break;
                        }
                    }
                    if (ok2 == 1) {
                        System.out.println("Introduceti parola:");
                        String par = scanner.next();
                        while (!(par == null ? listaCititori.get(userCurent1).parola == null : par.equals(listaCititori.get(userCurent1).parola))) {
                            System.out.println("Parola este gresita! Introduceti din nou");
                            par = scanner.next();
                        }
                    }
                        System.out.println("Autentificarea a avut succes!");
                    System.out.println("Lista mea de carti:'\n'");
                    listaCititori.get(userCurent1).afiseazaListaCarti();
                    nrActiuni++;
                    ScriereInFisier.scriereFisier(nrActiuni,"vizualizarea cartilor imprumutate" + ' ' + LocalDateTime.now(),"AdaugareActiuni.csv");
                    break;
                case 9:
                    ok = 0;
                    System.out.println("La revedere!");
            }
        }
    }
}
