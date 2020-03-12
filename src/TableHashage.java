
 import java.util.*;
//
 public class TableHashage {
     private ArrayList<LinkedList<MultiSet>> list = new ArrayList<>(140);

     public TableHashage (Reader reader) {
        for (int i = 0; i < 140; i++)
            list.add(null);
        createList(reader);
     }

     public boolean add(MultiSet multiSet) {
         int index = index(multiSet.hashCode());

         if (contains(multiSet)) {
             return false;
         }
         else {
             if (list.get(index) == null) {
                 list.set(index, new LinkedList<>());
                 return list.get(index).add(multiSet);
             }

         }
         return list.get(index).add(multiSet);
     }

     private void createList(Reader reader){

         while(reader.hasNext()) {
             add(new MultiSet(reader.next()));
         }
     }

     public boolean contains(MultiSet multiSet){
       int index = index(multiSet.hashCode());
            if (list.get(index) == null) {
                return false;
            }
         else {
             for (MultiSet multiSet1 : list.get(index)) {
                if (multiSet.equals(multiSet1)) {
                    return true;
                }
             }
         }
         return false;
     }

     public boolean containsKey(int hashcode) {
         return (list.get(index(hashcode)) != null);
     }

     private int index(int hashCode){
         return hashCode % (list.size());
     }

     public MultiSet getRandomMultiSetOfKey(int hashcode) {
         if (containsKey(hashcode)) {
             int index = list.get(index(hashcode)).size();
             return list.get(index(hashcode)).get(randomIndex(index));
         }
         return null;
     }

     private int randomIndex(int index) {
         Random random = new Random();
         return random.nextInt(index);
     }

     public ArrayList<LinkedList<MultiSet>> getList(){ return list; }
 }

