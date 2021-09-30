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
    private static List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static List<String> noiKerNevek = feltolt("files/noikernev.txt");

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



    public static int velEgesz(int min, int max) {
        return random.nextInt(max-min+1)+min;
    }

    public static char velKarakter(char min, char max) {
        return (char)velEgesz(min, max);
    }

    public static String velVezeteknev() {
        return vezetekNevek.get(random.nextInt(vezetekNevek.size()));
        //return vezetekNevek.get(velEgesz(0,vezetekNevek.size()+1));
    }



    public static String velKeresztnev(boolean nem) {
        String keresztNev = "";
        if (nem){
           keresztNev = ferfiKerNevek.get(random.nextInt(ferfiKerNevek.size()));
        }else {
            keresztNev = noiKerNevek.get(random.nextInt(noiKerNevek.size()));
        }
        return keresztNev;
    }

    public static String velKeresztnev() {
        return velKeresztnev(random.nextBoolean());
    }

    public static String velTeljesnev(boolean nem) {
        return String.format("%s %s", velVezeteknev(), velKeresztnev(nem));
    }

    public static String velTeljesnev() {
        return velTeljesnev(random.nextBoolean());
    }

}
