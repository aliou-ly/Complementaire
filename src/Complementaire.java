
import java.util.*;


public class Complementaire {
    private TableHashage tableHashage;
    private MultiSet multiSet;

    public Complementaire (TableHashage tableHashage, MultiSet multiSet) {

        this.multiSet = multiSet;
    this.tableHashage = tableHashage;
    }

    public String complement() {
        for (LinkedList<MultiSet> list : tableHashage.getList()) {
            if (list != null) {
                for (MultiSet multiSet1 : list) {
                    int hashcode = Math.abs(multiSet.hashCode() - multiSet1.hashCode());
                    if (tableHashage.containsKey(hashcode)) {
                        MultiSet complement = tableHashage.getRandomMultiSetOfKey(hashcode);

                        return complement.getCaracter().toString() + multiSet1.getCaracter().toString();
                    }
                }
            }
        }
        return "pas de complementaire";
    }
}

