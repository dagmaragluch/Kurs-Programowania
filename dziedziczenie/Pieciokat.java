public class Pieciokat extends Figura{
    private double bok;
    public Pieciokat (double bok){
        this.bok = bok;

        if(bok<=0){
            throw new IllegalArgumentException();
        }
    }

    public double liczObwod(){
        return this.bok * 5.0;
    }

    public double liczPole(){
        return (1.37638*5*Math.pow(this.bok,2))/4.0;
        //return (Math.pow(this.bok,2) * Math.sqrt(5.0*(5.0+2.0*Math.sqrt(5)))) / 4.0;
    }


}