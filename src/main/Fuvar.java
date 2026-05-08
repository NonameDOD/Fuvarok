package main;

public class Fuvar {
    private String rendszam;
    private int idoMP;
    private double osszeg;
    private String fizetes;

    public Fuvar(String rendszam, int idoMP, double osszeg, String fizetes) {
        this.rendszam = rendszam;
        this.idoMP = idoMP;
        this.osszeg = osszeg;
        this.fizetes = fizetes;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getIdoMP() {
        return idoMP;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizetes() {
        return fizetes;
    }

    @Override
    public String toString() {
        return "Fuvar{" + "rendszam=" + rendszam + ", idoMP=" + idoMP + ", osszeg=" + osszeg + ", fizetes=" + fizetes + '}';
    }
    
    
}
