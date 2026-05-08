package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FuvarokFeladat {
    private static List<Fuvar> fuvarok = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");
        List<String> sorok = Files.readAllLines(path);
        sorok.remove(0);
        
        for (String sor : sorok) {
            String[] s = sor.split(",");
            Fuvar fuvar = new Fuvar(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]),s[3]);
            fuvarok.add(fuvar);
        }

        for (Fuvar fuvar : fuvarok) {
            System.out.println(fuvar.toString());
        }
        feladatok();

    }
    private static void feladatok() {
        System.out.println("Összes fuvar értéke: "+osszeg());
        System.out.println("Legdrágább fuvar rendszáma: "+maxRendszam());
        System.out.println("Legolcsóbb fuvar forintban: "+minOsszegFT()+"FT");
    }

    private static String maxRendszam() {
        int maxI = 0;
        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getOsszeg() > fuvarok.get(maxI).getOsszeg()) {
                maxI = i;
            }
        }
        return fuvarok.get(maxI).getRendszam();
    }
    private static int minOsszegFT() {
        int minI = 0;
        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getOsszeg() < fuvarok.get(minI).getOsszeg()) {
                minI = i;
            }
        }
        return (int)fuvarok.get(minI).getOsszeg() * 355;
    }

    private static int osszeg() {
        int osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg += fuvarok.get(i).getOsszeg();
        }
        return osszeg;
    }
    
}
