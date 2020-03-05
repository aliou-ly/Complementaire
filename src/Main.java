import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/dict.txt");
        Reader dictionnaire = new Reader(file);
        TableHashage tableHashage = new TableHashage();
        Ensemble ensemble = new Ensemble("tommot");
        Complementaire complementaire = new Complementaire(ensemble, tableHashage, new Reader(file));
        ArrayList<String> wordsFormed = new ArrayList<>();

        for (String str : dictionnaire) {
            tableHashage.add(str);
        }
        System.out.println(complementaire.complement1());
    }

}