import java.util.ArrayList;

public class Ensemble {
    private ArrayList<Character> caracter = new ArrayList<>();
    public Ensemble(String string) {
        for (char caracters: string.toCharArray()) {
            this.caracter.add(caracters);
        }
    }

    public ArrayList<Character> getCaracter() {
        caracter.sort(Character::compareTo);
        return caracter;
    }

    public boolean equals(Ensemble ensemble) {
        return this.getCaracter().equals(ensemble.getCaracter());
    }

    public boolean contains(char character) {

        return caracter.contains(character);
    }

    public boolean contains(Character character) {
        return caracter.contains(character);
    }
}