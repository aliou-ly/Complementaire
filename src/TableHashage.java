
 import java.util.*;
//
 public class TableHashage {
     private ArrayList<LinkedList<MultiSet>> list = new ArrayList<>(140);
     private Reader reader;
     public TableHashage (Reader reader) {
         this.reader = reader;
     }

     public boolean add(MultiSet multiSet) {
         int index = index(multiSet.hashCode());

         if (contains(multiSet)) {
             return false;
         }
         else {
             if (list.get(index) == null){
                 list.set(index, new LinkedList<>());
                 return list.get(index).add(multiSet);
             }
             else {
                return list.get(index).add(multiSet);
             }
         }
     }

     private boolean CreateList(Reader reader){
         boolean booleen = false;
         BoucleWhile:
         while(reader.hasNext()){
            booleen = add(new MultiSet(reader.next()));
         }
         return booleen;
     }

     public boolean contains(MultiSet multiSet){
       int index = index(multiSet.hashCode());

         return list.get(index).contains(multiSet);
     }

     private int index(int hashCode){
         return hashCode % (list.size()-1);
     }
 }
 /*
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
*/