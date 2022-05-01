package Biblioteca;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PopulareDinFisier {
    private static PopulareDinFisier single_instance = null;
    private PopulareDinFisier(){
    }
    public List<Autori> citireDinFisier(String fisier){
        List<Autori> list = new ArrayList<Autori>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fisier));
            String line = "";

            while( (line = in.readLine()) != null ) {
                String [] fields = line.replaceAll(" ", "").split(",");
                Autori a = new Autori(Integer.parseInt(fields[0]), fields[1], fields[2]);
                list.add(a);
            }
        in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Cititori> citireCititori(String fisier){
        List<Cititori> list = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fisier));
            String line = "";

            while( (line = in.readLine()) != null ) {
                String [] fields = line.replaceAll(" ", "").split(",");
                Cititori c = new Cititori(fields[0], fields[1]);
                list.add(c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static PopulareDinFisier getInstance()
    {
        if (single_instance == null)
            single_instance = new PopulareDinFisier();

        return single_instance;
    }
}
