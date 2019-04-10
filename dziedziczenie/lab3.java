// autor: Dagmara Gluch

public class lab3{
    public static void main (String[] args){
        int licznik = 1;    //licznik liczb za tablicą literek
        int parametry = 0;  //liczba oczekiwanych parametrow


        if(args.length<1){
            System.out.println("brak parametrow");
            System.exit(0);
        }

        char[] figury = args[0].toCharArray();  //coby literki byly osobno


        for(int i=0; i<figury.length; i++){
            if(figury[i]=='o' || figury[i]=='s' || figury[i]=='p'){
                parametry++;
            }
            if(figury[i]=='c'){
                parametry=parametry+5;
            }
        }

        //System.out.println("ile parametrow jest = "+(args.length-1));
        //System.out.println("ile parametrow  powinno byc = "+parametry);

        if((args.length-1)<parametry){
            System.out.println("za malo parametrow");
            System.exit(0);
        }


        Figura[] tabFigur = new Figura[figury.length];  //tworzymy tablice typu Figura

        for (int i = 0; i<figury.length; i++){
            switch(figury[i]){
                case 'o':

                    System.out.println("Figura #"+i+": Kolo");

                    try{
                        tabFigur[i] = new Kolo(Double.parseDouble(args[licznik]));
                        System.out.println("Obwod: " + tabFigur[i].liczObwod());
                        System.out.println("Pole: " + tabFigur[i].liczPole());
                    }
                    catch (IllegalArgumentException ex1){
                        System.out.println("zly promien");
                    }

                    //tabFigur[i] = new Kolo(Double.parseDouble(args[licznik]));
                    System.out.println("----------------");
                    licznik++;      //i idziemy do kolejnej liczby z args
                    break;

                case 'c':
                    if (args[licznik].equals(args[licznik+1]) && args[licznik+1].equals(args[licznik+2]) && args[licznik+2].equals(args[licznik+3])){  //i wiemy ze to kwadrat lub romb
                        if (Double.parseDouble(args[licznik+4]) == 90.0){       //czyli jest to kwadrat
                            System.out.println("Figura #"+i+": Kwadrat");

                            try{
                                tabFigur[i] = new Kwadrat(Double.parseDouble(args[licznik]));
                                System.out.println("Obwod: " + tabFigur[i].liczObwod());
                                System.out.println("Pole: " + tabFigur[i].liczPole());
                            }
                            catch (IllegalArgumentException ex2){
                                System.out.println("zly bok");
                            }
                        }
                        else {    //jak nie kwadrat to romb
                            System.out.println("Figura #"+i+": Romb");

                            try{
                                try{
                                    tabFigur[i] = new Romb(Double.parseDouble(args[licznik]), Double.parseDouble(args[licznik+4]));
                                    System.out.println("Obwod: " + tabFigur[i].liczObwod());
                                    System.out.println("Pole: " + tabFigur[i].liczPole());
                                }
                                catch (IllegalArgumentException ex3){
                                    System.out.println("zly kat");
                                }
                            }
                            catch (IllegalArgumentException ex2){
                                System.out.println("zly bok");
                            }
                        }
                    }
                    else {        //jak nie jedno ani drugie to prostokat, ale czy aby na pewno
                        if((args[licznik].equals(args[licznik+1]) && args[licznik+2].equals(args[licznik+3]))
                              //  || (args[licznik].equals(args[licznik+2]) && args[licznik+1].equals(args[licznik+3]))
                                ){
                            System.out.println("Figura #"+i+": Prostokat");
                            try{
                                tabFigur[i] = new Prostokat(Double.parseDouble(args[licznik]), Double.parseDouble(args[licznik+2]));
                                System.out.println("Obwod: " + tabFigur[i].liczObwod());
                                System.out.println("Pole: " + tabFigur[i].liczPole());
                            }
                            catch (IllegalArgumentException ex2){
                                System.out.println("zly bok");
                            }
                        }
                        else{
                            System.out.println("nie mozna stworzyc czworokatu");
                            tabFigur[i]=null;
                        }
                    }
                    System.out.println("----------------");
                    licznik+=5;
                    break;

                case 'p':
                    System.out.println("Figura #"+i+": Pieciokat");
                    try{
                        tabFigur[i] = new Pieciokat(Double.parseDouble(args[licznik]));
                        System.out.println("Obwod: " + tabFigur[i].liczObwod());
                        System.out.println("Pole: " + tabFigur[i].liczPole());
                    }
                    catch (IllegalArgumentException ex2){
                        System.out.println("zly bok");
                    }
                    System.out.println("----------------");
                    licznik++;
                    break;

                case 's':
                    System.out.println("Figura #"+i+": Szesciokat");
                    try{
                        tabFigur[i] = new Szesciokat(Double.parseDouble(args[licznik]));
                        System.out.println("Obwod: " + tabFigur[i].liczObwod());
                        System.out.println("Pole: " + tabFigur[i].liczPole());
                    }
                    catch (IllegalArgumentException ex2){
                        System.out.println("zly bok");
                    }
                    System.out.println("----------------");
                    licznik++;
                    break;

                default:
                    System.out.println("bledna figura");
                    System.out.println("----------------");
                    tabFigur[i]=null;
                    break;
            }
        }

    }
}