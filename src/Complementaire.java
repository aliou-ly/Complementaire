
import java.util.ArrayList;
import java.util.Random;


public class Complementaire {
    private Ensemble ensemble;
    private TableHashage hashtable;
    private Reader dictionnaire;

    public Complementaire(Ensemble ensemble, TableHashage hashage, Reader reader) {
        this.ensemble = ensemble;
        this.hashtable = hashage;
        this.dictionnaire = reader;
    }
    public String complement1() {
        ArrayList<String> complement = new ArrayList<>();
        StringBuilder sequence =  new StringBuilder(chainage());
        ArrayList<String> listFormed = Utils.listWordsFormed(dictionnaire, (String) chainage());

        BoucleFor:
        for (String str : listFormed) {
            for (char caracter : str.toCharArray()){
                sequence.deleteCharAt(sequence.indexOf(String.valueOf(caracter)));
            }
            if (hashtable.containsKey(sequence)){
                listFormed.add(str);
                int index = hashtable.HasSameKey(sequence).size();
                return listFormed.toString();
            }

        }
        return "[]";
    }

    public String complement(){
        StringBuilder str = (StringBuilder) chainage();
        int index = 1;
        ArrayList<String> list = new ArrayList<>();

        while(index < str.length()) {
           String str1 = (String) str.subSequence(0,index);
           String str2 = (String) str.subSequence(index,str.length());

           if (hashtable.containsKey(str1) && hashtable.containsKey(str2)) {
                int size1 = hashtable.HasSameKey(str1).size();
                int size2 = hashtable.HasSameKey(str2).size();
                list.add(hashtable.HasSameKey(str1).get(new Random().nextInt(size1)));
                list.add(hashtable.HasSameKey(str2).get(new Random().nextInt(size2)));
                return list.toString();
           }
            index++;
        }

        return "[]";
    }

    protected CharSequence chainage() {
        CharSequence str = new String();
        for (char caracter : ensemble.getCaracter()){
            str = str + String.valueOf(caracter);
        }
        return str;
    }
}

