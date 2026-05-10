package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FuvarokFeladat {

    private static List<Fuvar> fuvarok = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");
        List<String> sorok = Files.readAllLines(path);
        sorok.remove(0);

        for (String sor : sorok) {
            String[] s = sor.split(",");
            Fuvar fuvar = new Fuvar(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]), s[3]);
            fuvarok.add(fuvar);
        }

        for (Fuvar fuvar : fuvarok) {
            System.out.println(fuvar.toString());
        }
        feladatok();

    }

    private static void feladatok() {
        System.out.println("Összes fuvar értéke: " + osszeg());
        System.out.println("Legdrágább fuvar rendszáma: " + maxRendszam());
        System.out.println("Legolcsóbb fuvar forintban: " + minOsszegFT() + "FT");
        System.out.println("Hány kártyás fizetés volt: " + kartyasDB());
        System.out.println("Minden fizetési mód meghatározott: " + fizetesEldontes());
        System.out.println("Hány darab autó van a rendszerben: " + autoDB());
        System.out.println("Hányféle fizetési mód van: " + fizetesDB());
        System.out.println("Melyik autó mennyi fuvart teljesített:\n "+fuvarStatisztika());
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
        return (int) fuvarok.get(minI).getOsszeg() * 355;
    }

    private static int osszeg() {
        int osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg += fuvarok.get(i).getOsszeg();
        }
        return osszeg;
    }

    private static int kartyasDB() {
        int osszeg = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getFizetes().equals("kártya")) {
                osszeg += fuvarok.get(i).getOsszeg();
            }

        }
        return osszeg;
    }

    private static boolean fizetesEldontes() {
        int i = 0;
        while (i < fuvarok.size() && !fuvarok.get(i).getFizetes().equals("-")) {
            i++;
        }
        return i >= fuvarok.size();
    }

    private static int autoDB() {
        HashSet<String> autoDb = new HashSet<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            autoDb.add(fuvarok.get(i).getFizetes());
        }
        return autoDb.size();
    }

    private static int fizetesDB() {
        HashSet<String> autoDb = new HashSet<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            autoDb.add(fuvarok.get(i).getFizetes());
        }
        return autoDb.size();
    }

    private static String fuvarStatisztika() {
        HashMap<String, Integer> stat = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
            String rendszam = fuvar.getRendszam();
            if (stat.containsKey(rendszam)) {
                stat.put(rendszam, stat.get(rendszam) + 1);
            } else {
                stat.put(rendszam, 1);
            }
        }
        String eredmeny = "";
        for (String rendszam : stat.keySet()) {
            eredmeny += rendszam + ": " + stat.get(rendszam) + " fuvar\n";
        }
        return eredmeny;
    }
}
