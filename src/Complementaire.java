
import java.util.ArrayList;
import java.util.NoSuchElementException;
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
        ArrayList<String> listFormed = Utils.listWordsFormed(dictionnaire, (String) chainage());

        BoucleFor:
        for (String str : listFormed) {
            StringBuilder sequence =  new StringBuilder(chainage());
            for (char caracter : str.toCharArray()){
                sequence.deleteCharAt(sequence.indexOf(String.valueOf(caracter)));
            }
            if (hashtable.containsKey(sequence)){
                int index = RandomIndex(sequence,str);
                String str1 = hashtable.HasSameKey(sequence).get(index);
                boolean booleen = ensemble.equals(new Ensemble(str.concat(str1)));

                if (!booleen) {continue; }
                complement.add(str);
                complement.add(str1);
                return complement.toString();
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
    public int RandomIndex(CharSequence str, CharSequence str1) {
        Random random = new Random();
        int index = random.nextInt(hashtable.HasSameKey(str).size());
        if (hashtable.hashcode(str) == hashtable.hashcode(str1)) {
            if (hashtable.HasSameKey(str).size() <=1 )
                throw new NoSuchElementException();
            while (index == hashtable.HasSameKey(str).indexOf(str1))
                index = random.nextInt(hashtable.HasSameKey(str).size());
        }
        return index;
    }
}

