public class Romb extends Czworokat{
    public Romb(double bok, double kat){
        //this.bok1 = bok;
        //this.bok2 = bok;
        //this.bok3 = bok;
        //this.bok4 = bok;
        //this.kat = kat;

        super(bok, bok, bok, bok, kat);

        if(kat<=0 || kat>=180){
            throw new IllegalArgumentException();
        }

    }

    public double liczObwod(){
        return this.bok1 * 4.0;
    }

    public double liczPole(){

        double radian = Math.toRadians(kat);

        return Math.pow(this.bok1, 2) * Math.sin(radian);
    }

}