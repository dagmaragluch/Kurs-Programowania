public class RzymArab {

    public static void main(String[] args){

        int n=0;
        String m="";

        if(args.length<1){
            System.out.println("brak argumentow");
        }

        for(int i=0; i<args.length; i++) {
            try{
                m=args[i];
                n = Integer.parseInt(args[i]);
                try{
                    System.out.println(args[i] + " - " + Lista2.arab2rzym(n));
                }
                catch(RzymArabException ex2) {
                System.out.println(args[i] + " - " + ex2.getMessage());
                }
            }
            catch(NumberFormatException ex1) {
                System.out.println(args[i] + " - to nie jest int");

                try{
                    System.out.println(args[i] + " - " + Lista2.rzym2arab(m));
                }
                catch(RzymArabException ex3) {
                    System.out.println(args[i] + " - " + ex3.getMessage());
                }
            }
        }
    }
}
