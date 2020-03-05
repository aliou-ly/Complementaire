import java.util.ArrayList;

public class MultiSet {
    private ArrayList<Character> caracter = new ArrayList<>();
    private int hashCode;

    public MultiSet(String string) {
        this.hashCode = string.codePoints().sum();
        for (char caracters: string.toCharArray()) {
            this.caracter.add(caracters);
        }
    }

    public ArrayList<Character> getCaracter() {
        caracter.sort(Character::compareTo);
        return caracter;
    }

    public boolean equals(MultiSet multiSet) {
        return this.getCaracter().equals(multiSet.getCaracter());
    }

    public boolean contains(char character) {

        return caracter.contains(character);
    }

    public boolean contains(Character character) {
        return caracter.contains(character);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}