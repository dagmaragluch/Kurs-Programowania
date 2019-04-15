public class Element {  //poj artykul z iloscią i ceną
    private String artykul;
    private int ilosc;
    private double cena;

    Element(String artykul, int ilosc, double cena) {
        this.artykul = artykul;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "Element{" +
                "artykul='" + artykul + '\'' +
                ", ilosc=" + ilosc +
                ", cena=" + cena +
                '}';
    }

    public String getArtykul() {
        return artykul;
    }

    public int getIlosc() {
        return ilosc;
    }

    public double getCena() {
        return cena;
    }
}
