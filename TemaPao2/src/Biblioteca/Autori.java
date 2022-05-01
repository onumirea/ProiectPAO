package Biblioteca;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Autori {
    public int anulNasterii;
    public String nume;
    public String prenume;
    public List<Carti> listaCarti = new ArrayList<Carti>();

    public Autori(int anulNasterii, String nume, String prenume){
        this.anulNasterii = anulNasterii;
        this.nume = nume;
        this.prenume = prenume;
    }
    public Autori(){
        this.anulNasterii = 0;
        this.nume = "Anonim";
        this.prenume = "Anonim";
    }
    public void addCarti(Carti carte){
        listaCarti.add(carte);
    }
    public void afiseazaListaCarti(){
        if(listaCarti.size() == 0){
            System.out.println("Autorul inca nu are carti in lista!\n");
        }
        else
            for (int i = 0; i< listaCarti.size(); i++){
                System.out.println("Titlu:" + listaCarti.get(i).titlu + ", Rating: " + listaCarti.get(i).rating);
            }
    }
}
