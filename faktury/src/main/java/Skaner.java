import java.util.Scanner;

public class Skaner {

    Klient nazwa_wprowadzona;
    String dodawany_artykul;
    int dodawane_sztuki=1;
    double dodawana_cena;
    Klient klient;
    int ilosc_elementow=1;


    void wprowadz_dane_do_wyswietl_fakture() {

        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj nazwe klienta dla którego chcesz zobaczyc faktury");  //użytkownik wprowadza z palca nazwe kliente dla którego chce zobaczyc fakture
        String klient2 = odczyt.nextLine();     //zamiana Stringa na obiekt Klient
        nazwa_wprowadzona = new Klient(klient2);
    }


    void wprowadz_dane_do_dodaj_element() {

        Scanner skaner1 = new Scanner(System.in);   //skaner do pobrania wartośc elementów
        Scanner skaner2 = new Scanner(System.in);
        Scanner skaner3 = new Scanner(System.in);

        System.out.println("Podaj nazwe artykulu");
        dodawany_artykul = skaner1.nextLine();

        do {
            if(dodawane_sztuki<=0){
                System.out.println("Ilość sztuk musi być dodatnia. Wprowadz jeszcze raz");
            }
            System.out.println("Podaj ile sztuk");
            dodawane_sztuki = skaner2.nextInt();
        }while(dodawane_sztuki<=0);


        System.out.println("Podaj cene");
        dodawana_cena = skaner3.nextDouble();
    }


    void wprowadz_dane_do_dodaj_fakture() {
        Scanner odczyt1 = new Scanner(System.in);
        Scanner odczyt2 = new Scanner(System.in);

        System.out.println("Podaj nazwe klienta dla którego chcesz wystawic fakture");  //zczytanie klienta
        String klient1 = odczyt2.nextLine();
        klient = new Klient(klient1);

        do {
            if(ilosc_elementow<=0){
                System.out.println("Ilość elementow musi być dodatnia. Wprowadz jeszcze raz");
            }
            System.out.println("Podaj ilosc elementow faktury");
            ilosc_elementow = odczyt1.nextInt();
        }while(ilosc_elementow<=0);

    }

}
