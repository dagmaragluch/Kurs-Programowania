public class Lista2 {

    private static int arab[] = {1000, 500, 100, 50, 10, 5, 1};
    private static String rzym = "MDCLXVI";
    private static int rozmiar = arab.length;


    public static String arab2rzym(int liczba) throws RzymArabException {

        int i = 0;  //pozycja w rzym i arab
        String str = "";

        if (liczba > 0 && liczba < 4000) {
            while (liczba > 0 && i < rozmiar) {

                //System.out.println("arab[i]: " + arab[i]);
                //System.out.println("rzym[i]: " + rzym.charAt(i));
                //System.out.println("liczba: " + liczba);

                if (liczba >= arab[i]) {
                    liczba = liczba - arab[i];
                    str = str + rzym.charAt(i);
                } else if ((i % 2 == 0) &&       //spr czy aktualnie rozpatrywana literka jest postaci 10xx
                        (i < rozmiar - 2) &&       //spr czy licba jest postaci 9xx
                        (liczba >= arab[i] - arab[i + 2]) &&
                        (arab[i + 2] != arab[i] - arab[i + 2])) {
                    liczba = liczba - arab[i] + arab[i + 2];
                    str = str + rzym.charAt(i + 2);
                    str = str + rzym.charAt(i);
                    i++;
                } else if ((i % 2 == 1) &&       //spr czy aktualnie rozpatrywana literka jest postaci 5xx
                        (i < rozmiar - 1) &&       //spr czy liczba jest postaci 4xx
                        (liczba >= arab[i] - arab[i + 1]) &&
                        (arab[i + 1] != arab[i] - arab[i + 1])) {
                    liczba = liczba - arab[i] + arab[i + 1];
                    str = str + rzym.charAt(i + 1);
                    str = str + rzym.charAt(i);
                    i++;
                } else {
                    i++;
                }
            }
        } else {
            throw new RzymArabException("zly zakres");
        }

        return str;
    }

    /****************************************/

    public static int rzym2arab(String number) throws RzymArabException {

        int i = 0; //pozycja w rzym i arab
        int j = 0; //pozycja w number
        int wynik = 0;
        int dlugosc = number.length();
        int m = 0;    //liczniki poszczegolnych literek
        int d = 0;
        int c = 0;
        int l = 0;
        int x = 0;
        int v = 0;
        int i2 = 0;


        while ((j < dlugosc) && (i < rozmiar)) {

            if (number.charAt(j) == rzym.charAt(i)) {

                if (number.charAt(j) == rzym.charAt(0))   //zliczanie poszczegolnych literek
                    m++;
                if (number.charAt(j) == rzym.charAt(1))
                    d++;
                if (number.charAt(j) == rzym.charAt(2))
                    c++;
                if (number.charAt(j) == rzym.charAt(3))
                    l++;
                if (number.charAt(j) == rzym.charAt(4))
                    x++;
                if (number.charAt(j) == rzym.charAt(5))
                    v++;
                if (number.charAt(j) == rzym.charAt(6))
                    i2++;

                wynik = wynik + arab[i];
                j++;

            } else if ((i % 2 == 0) &&  //spr czy aktualnie rozpatrywana liczba jest postaci 10xx
                    (i < rozmiar - 2) &&   //spr czy licba jest postaci 9xx
                    (j < dlugosc - 1) &&
                    (number.charAt(j) == rzym.charAt(i + 2)) &&
                    (number.charAt(j + 1) == rzym.charAt(i))) {

                if (number.charAt(j + 1) == rzym.charAt(0))     //liczenie literek (mozliwe liczby postaci 9xx: CM, XC, IX)
                    m++;
                if (number.charAt(j) == rzym.charAt(2) || number.charAt(j + 1) == rzym.charAt(2))
                    c++;
                if (number.charAt(j) == rzym.charAt(4) || number.charAt(j + 1) == rzym.charAt(4))
                    x++;
                if (number.charAt(j) == rzym.charAt(6))
                    i2++;

                /*****************/
                if(((number.charAt(j+1) == rzym.charAt(0)) && (number.charAt(j) == rzym.charAt(2)))  && ((number.charAt(j+2) == rzym.charAt(2)) || (number.charAt(j+2) == rzym.charAt(1)))){    //CM
                    throw new RzymArabException("zle literki");
                }
                if(((number.charAt(j+1) == rzym.charAt(2)) && (number.charAt(j) == rzym.charAt(4)))  && ((number.charAt(j+2) == rzym.charAt(2)) || (number.charAt(j+2) == rzym.charAt(3)) || (number.charAt(j+2) == rzym.charAt(4)))){    //XC
                    throw new RzymArabException("zle literki");
                }
                if(((number.charAt(j+1) == rzym.charAt(4)) && (number.charAt(j) == rzym.charAt(6)))  && ((number.charAt(j+2) == rzym.charAt(5)) || (number.charAt(j+2) == rzym.charAt(6)))){    // IX
                    throw new RzymArabException("zle literki");
                }
                /*****************/

                wynik = wynik + arab[i] - arab[i + 2];
                j = j + 2;
                i++;

            } else if ((i % 2 == 1) &&      //spr czy aktualnie rozpatrywana liczba jest postaci 5xx
                    (i < rozmiar - 1) &&   //spr czy licba jest postaci 4xx
                    (j < dlugosc - 1) &&
                    (number.charAt(j) == rzym.charAt(i + 1)) &&
                    (number.charAt(j + 1) == rzym.charAt(i))) {

                if (number.charAt(j + 1) == rzym.charAt(1))     //liczenie literek (mozliwe liczby postaci 4xx: CD, XL, IV)
                    d++;
                if (number.charAt(j) == rzym.charAt(2))
                    c++;
                if (number.charAt(j + 1) == rzym.charAt(3))
                    l++;
                if (number.charAt(j) == rzym.charAt(4))
                    x++;
                if (number.charAt(j + 1) == rzym.charAt(5))
                    v++;
                if (number.charAt(j) == rzym.charAt(6))
                    i2++;

                wynik = wynik + arab[i] - arab[i + 1];
                j = j + 2;
                i++;

            } else {
                i++;
            }
        }

        if (i == rozmiar || d > 1 || l > 1 || v > 1 || m > 3 || c > 3 || x > 3 || i2 > 3) {     //spr czy nie bylo za duzo danych literek
            //wynik = -1;
            throw new RzymArabException("zle literki");
        }

        return wynik;
    }
}
