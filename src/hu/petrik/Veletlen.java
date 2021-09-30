package hu.petrik;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public final class Veletlen {
    private static Random random = new Random();
    private static List<String> vezetekNevek = feltolt("files/veznev.txt");
    private static List<String> ferfiNevek = feltolt("files/ferfikernev.txt");
    private static List<String> noiNevek = feltolt("files/noikernev.txt");

    private Veletlen() {}

    private static List<String> feltolt(String fajlnev) {

        List<String> fajlSorai =  new ArrayList<String>();
        try {
            fajlSorai = Files.readAllLines(Paths.get(fajlnev));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fajlSorai;
    }


}
