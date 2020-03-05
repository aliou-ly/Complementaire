import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ensemble {
    private char[] caracter;
    public Ensemble(String string) {
        caracter = string.toCharArray();
    }

    public char[] getCaracter() {
        return caracter;
    }
}
