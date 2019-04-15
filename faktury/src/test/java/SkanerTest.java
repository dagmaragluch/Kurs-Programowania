import org.junit.Test;

import java.util.Scanner;

public class SkanerTest {


    @Test
    public void wprowadz_dane_do_dodaj_element_test() {

        Skaner skaner = new Skaner();

        Scanner skaner1 = new Scanner(System.in);
        Scanner skaner2 = new Scanner(System.in);
        Scanner skaner3 = new Scanner(System.in);

//        System.out.println("Podaj nazwe artykulu");
//        skaner.dodawany_artykul = skaner1.nextLine();

        int dodawane_sztuki_test = -11;
//
        do {
            if (dodawane_sztuki_test <= 0) {
                System.out.println("Ilość sztuk musi być dodatnia. Wprowadz jeszcze raz");
            }
            System.out.println("Podaj ile sztuk");
            dodawane_sztuki_test = skaner2.nextInt();
        } while (dodawane_sztuki_test <= 0);

        System.out.println("Podaj cene");
        skaner.dodawana_cena = skaner3.nextDouble();
    }

//    @Test
//    public void wprowadz_dane_do_dodaj_fakture() {
//    }
}