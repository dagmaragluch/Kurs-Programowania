public class Kolo extends Figura{
    private double promien;
    public Kolo (double promien){

        this.promien = promien;

            if(promien<=0){
                throw new IllegalArgumentException();
            }
    }

    public double liczObwod(){
        return 2.0 * Math.PI * this.promien;
    }

    public double liczPole(){
        return Math.PI * Math.pow(this.promien, 2);
    }

}