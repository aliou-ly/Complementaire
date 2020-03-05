import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/dict.txt");
        Reader dictionnaire = new Reader(file);
        TableHashage tableHashage = new TableHashage();
        Ensemble ensemble = new Ensemble("monpom");
        Complementaire complementaire = new Complementaire(ensemble, tableHashage, new Reader(file));
        String mot = "pom", mot2 = "mot";
        for (String str : dictionnaire) {
            tableHashage.add(str);
        }
        System.out.println(complementaire.complement1());
    }

}