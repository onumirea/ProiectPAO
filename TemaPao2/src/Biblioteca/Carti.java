package Biblioteca;

public class Carti {
    String titlu;
    int nrPagini;
    String dataPublicarii;
    int rating;
    Autori autor;
    public Carti(int nrPagini, String titlu, String dataPublicarii) {
        this.nrPagini = nrPagini;
        this.dataPublicarii = dataPublicarii;
        this.rating = 0;
        this.titlu = titlu;
        this.autor = null;
    }

}
