public class Kwadrat extends Czworokat{
    public Kwadrat(double bok){
//        this.bok1 = bok;
//        this.bok2 = bok;
//        this.bok3 = bok;
//        this.bok4 = bok;
//        this.kat = 90;
        super(bok, bok, bok, bok, 90.0);

    }

    public double liczObwod(){
        return this.bok1 * 4.0;
    }

    public double liczPole(){
        return Math.pow(this.bok1,2);
    }
}