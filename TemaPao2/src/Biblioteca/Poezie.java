package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Poezie implements Sectiuni{
    public List<Carti> listaCarti = new ArrayList<Carti>();
    @Override
    public void mesajSectiune() {
        System.out.println("Poezie!");
    }
    public void addCarti(Carti carte){
        listaCarti.add(carte);
    }
    public void afisareListaCarti(){
        if(listaCarti.size() == 0){
            System.out.println("inca nu exista carti in aceasta categorie!");
        }
        else
            for (int i = 0; i< listaCarti.size(); i++){
                System.out.println("Titlu:" + listaCarti.get(i).titlu + ", Autor: " + listaCarti.get(i).autor.prenume + ' ' + listaCarti.get(i).autor.nume + '-' + (i+1));
            }
    }
}
