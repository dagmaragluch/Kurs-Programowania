import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SpisFaktur spisFaktur = new SpisFaktur();
        Scanner odczyt = new Scanner(System.in);    //skanaer umożliwiający użytkownikowi wybór akcji
        int czy_zakonczyc = 1;

        while (czy_zakonczyc != 0) {

            System.out.println("Co chcesz zrobic? Jesli chcesz dodac fakture kliknij 1, jesli chcesz wyswietlic faktury kliknij 2");
            int co_robimy = odczyt.nextInt();

            if (co_robimy == 1) {   //dodawanie faktury

                boolean czyPoprawnieWprowadzono = false;

               do{
                  try{
                      spisFaktur.dodaj_fakture();
                      czyPoprawnieWprowadzono = true;
                  } catch (InputMismatchException ex) {
                      System.out.println("zły format! wprowadz dane jeszcze raz");
                      czyPoprawnieWprowadzono = false;
                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  }
               }  while(!czyPoprawnieWprowadzono);

                System.out.println("Czy chcesz jeszcze coś zrobić? Jeśli tak to wprowadz dowolny znak. Jeśli chcesz wyjść to wprowadź 0");
                czy_zakonczyc = odczyt.nextInt();
            }

            if (co_robimy == 2) {   //wyświetlanie faktur
                spisFaktur.wyswietl_fakture();

                System.out.println("Czy chcesz jeszcze coś zrobić? Jeśli tak to wprowadz dowolny znak. Jeśli chcesz wyjść to wprowadź 0");
                czy_zakonczyc = odczyt.nextInt();
            }
        }

    }
}
