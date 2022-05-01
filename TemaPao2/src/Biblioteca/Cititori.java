package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Cititori {
    String username;
    String parola;
    public List<Carti> listaCartiImprumutate = new ArrayList<Carti>();

    public Cititori(String username, String parola){
        this.username = username;
        this.parola = parola;
    }
    public Cititori(){
        this.username = "Guest";
        this.parola = "1234";
    }
    public void addCarti(Carti carte){
        listaCartiImprumutate.add(carte);
    }
    public void afiseazaListaCarti(){
        for (int i = 0; i< listaCartiImprumutate.size(); i++){
            System.out.println("Titlu:" + listaCartiImprumutate.get(i).titlu + ", Autor: " + listaCartiImprumutate.get(i).autor.prenume + ' ' + listaCartiImprumutate.get(i).autor.nume);
        }
    }

}
