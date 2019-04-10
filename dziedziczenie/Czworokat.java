public abstract class Czworokat extends Figura {
    public double bok1, bok2, bok3, bok4, kat;

    public Czworokat(double bok1, double bok2, double bok3, double bok4, double kat){
        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
        this.kat = kat;

        //super(bok1, bok2, bok3, bok4, kat);

        if(bok1<=0 || bok2<=0 || bok3<=0 || bok4<=0){
            throw new IllegalArgumentException();
        }
    }
}