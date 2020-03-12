import java.io.File;
import java.io.IOException;

//def
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/dict.txt");
        Reader dictionnaire = new Reader(file);
        TableHashage tableHashage = new TableHashage(dictionnaire);
        Complementaire complementaire = new Complementaire(tableHashage,new MultiSet("saisieencore"));

        System.out.println(complementaire.complement());
    }

}