import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class SpisFaktur implements ObslugaFaktur{

    private ArrayList<Faktura> listaFaktur = new ArrayList<Faktura>();
    private Skaner skaner = new Skaner();
    int j=0;

    public void wyswietl_fakture() {

        skaner.wprowadz_dane_do_wyswietl_fakture();

        int licznik = 0;    //czy/ile faktur dla danego klienta znaleziono

        for (int i = 0; i < listaFaktur.size(); i++) {
            if (skaner.nazwa_wprowadzona.getKlient().equals(listaFaktur.get(i).getKlientToString())) { //porównanie klienta wprowadzonego z aktualnie zczytanym z listy faktur
                System.out.println(listaFaktur.get(i).getKlientToString());
                listaFaktur.get(i).wyswietl_dodane_elementy();
                licznik++;
            }
        }
        if (licznik == 0 || listaFaktur.size() == 0) {
            System.out.println("Nie znaleziono zadnej faktury");
        }
    }


    public void dodaj_fakture() throws FileNotFoundException{

        skaner.wprowadz_dane_do_dodaj_fakture();

        ArrayList<Element> list = new ArrayList<Element>();
        Faktura faktura = new Faktura(skaner.klient, list);


        for (int i = 0; i < skaner.ilosc_elementow; i++) { //tworzenie listy elementów
            skaner.wprowadz_dane_do_dodaj_element();
            faktura.dadaj_element(skaner.dodawany_artykul, skaner.dodawane_sztuki, skaner.dodawana_cena);
        }
        listaFaktur.add(faktura);   //dodanie faktury do listy faktur
        zapis_faktury();
        System.out.println("dadano fakture!");
    }


    void zapis_faktury() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("BazaFaktur.txt");
        zapis.print("Faktura nr " + j);
        zapis.println(listaFaktur.get(j).getKlientToString());
        //zapis.println.listaFaktur.get(j).wyswietl_dodane_elementy();
        j++;

        zapis.close();
    }

}
