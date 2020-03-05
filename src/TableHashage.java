
 import java.util.*;

 public class TableHashage {
     private Hashtable<Integer,TreeSet<String>> list = new Hashtable<>();

    public ArrayList<String> HasSameKey(CharSequence string) {
            if (! list.containsKey(hashcode(string)))
                throw new NoSuchElementException();
            return new ArrayList<>(list.get(hashcode(string))) ;
    }

     public boolean add(String string) {
         if (! list.containsKey(hashcode(string))) {
            list.put(hashcode(string), new TreeSet<>());
            return list.get(hashcode(string)).add(string);

         }
         else {
             if (! list.get(hashcode(string)).contains(string)) {
                 return list.get(hashcode(string)).add(string);
             }
         }
         return false;
     }

     public boolean contains(CharSequence string) {
         if (! list.containsKey(hashcode(string))) {
             return false;
         }
         else {
            return list.get(hashcode(string)).contains(string);
         }
     }

     public boolean remove(String string) {
         if (contains(string)) {
             return list.get(hashcode(string)).remove(string);
         }
         return true;
     }

    public int hashcode(CharSequence string) {
        return string.codePoints().sum();
    }

    public boolean containsKey(CharSequence string) {

        return list.containsKey(hashcode(string));
    }

}
