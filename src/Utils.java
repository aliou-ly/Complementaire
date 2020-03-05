import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Utils {

    public static boolean isVowel(int codePoint) {
        switch (codePoint) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }

    public static boolean hasSameLetters(String word1, String word) {
        StringBuilder comparator = new StringBuilder(word1.toLowerCase());
        for (char caracter : word.toLowerCase().toCharArray()) {
            int index = comparator.indexOf(String.valueOf(caracter));
            if (index != -1 )
                comparator.deleteCharAt(index);
        }
        return (comparator.length() == 0);
    }


    public static ArrayList<String> listWordsFormed(Reader reader, String string) {
        if (! reader.hasNext())
            throw new NoSuchElementException();
        ArrayList<String> words = new ArrayList<>();
        for (String str : reader)
            if (hasSameLetters(str,string))
                words.add(str);
        return words;
    }

}
