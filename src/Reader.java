
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader implements Iterator<String> {
    private Scanner fileScanner;
    public Reader(File file) throws FileNotFoundException {
        this.fileScanner = new Scanner(file);
    }


    public boolean hasNext(){
        return fileScanner.hasNextLine();
    }


    public String next() {
        if (! hasNext())
            throw new NoSuchElementException();

        Scanner lineScanner = new Scanner(fileScanner.nextLine());
        if (! lineScanner.hasNext())
            throw new NoSuchElementException();

        return lineScanner.nextLine();
    }

    /*@Override
    public Iterator<String> iterator() {
        ArrayList<String> words = new ArrayList<>();

        while (hasNext())
            words.add(next());
        return words.iterator();
    }*/
}
