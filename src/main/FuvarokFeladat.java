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
        
    }
    
}
