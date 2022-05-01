package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public interface Sectiuni {
    public List<Carti> listaCarti = new ArrayList<Carti>();
    public void mesajSectiune();
    public void afisareListaCarti();

}
