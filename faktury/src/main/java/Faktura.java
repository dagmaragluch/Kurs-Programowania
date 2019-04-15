import java.util.ArrayList;

public class Faktura {
    private Klient klient;
    private ArrayList<Element> elementy;

    Faktura(Klient klient, ArrayList<Element> elementy) {
        this.klient = klient;
        this.elementy = elementy;
    }

    public void dadaj_element (String artykul, int ilosc, double cena) {     //tworzy i dodaje element do listy elementów
        Element element = new Element(artykul, ilosc, cena);
        elementy.add(element);
    }

    void wyswietl_dodane_elementy() {
        for (Element anElementy : elementy) {
            System.out.println(anElementy.toString());
        }
    }

    public String getKlientToString() {
        return klient.toString();
    }

    public ArrayList<Element> getElementy() {
        return elementy;
    }
}
