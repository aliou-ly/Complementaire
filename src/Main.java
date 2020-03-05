import java.io.File;
import java.io.IOException;

//def
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/dict.txt");
        Reader dictionnaire = new Reader(file);
        TableHashage tableHashage = new TableHashage();
        MultiSet multiSet = new MultiSet("plusencore");
        //Complementaire complementaire = new Complementaire(multiSet, tableHashage, new Reader(file));

        for (String str : dictionnaire) {
            System.out.println(new MultiSet(str).hashCode());
        }

        //System.out.println(multiSet.getCaracter().toString());
        //System.out.println(complementaire.complement1());
    }

}