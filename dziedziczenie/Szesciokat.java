public class Szesciokat extends Figura{
    private double bok;
    public Szesciokat (double bok){
        this.bok = bok;

        if(bok<=0){
            throw new IllegalArgumentException();
        }
    }

    public double liczObwod(){
        return this.bok * 6.0;
    }

    public double liczPole(){
        return (3.0 * Math.pow(this.bok,2) * Math.sqrt(3)) / 2.0;
    }
}