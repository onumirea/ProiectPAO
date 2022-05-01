package Biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScriereInFisier {
    private static ScriereInFisier single_instance = null;
    private ScriereInFisier(){
    }
    public static void scriereFisier(int operatie, String deScrisInFisier, String fisier) {
        try {
            if (operatie == 1) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fisier, false));
                writer.write(deScrisInFisier);
                writer.close();
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fisier, true));
                writer.append('\n');
                writer.append(deScrisInFisier);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Exceptie I/O");
        }
    }

    public static ScriereInFisier getInstance()
    {
        if (single_instance == null)
            single_instance = new ScriereInFisier();

        return single_instance;
    }
}
