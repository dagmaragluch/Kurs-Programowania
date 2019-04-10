public class Prostokat extends Czworokat{
    public Prostokat(double bokA, double bokB){
        //this.bok1 = bokA;
        //this.bok2 = bokA;
        //this.bok3 = bokB;
        //this.bok4 = bokB;
        //this.kat = 90;

        super(bokA, bokA, bokB, bokB, 90.0);

    }

    public double liczObwod(){
//
//        if(bok1==bok2){
           return this.bok1 * 2.0 + this.bok3 * 2.0;
//        }
//        else{
//           return this.bok1 * 2.0 + this.bok2 * 2.0;
//        }
    }

    public double liczPole(){

//        if(bok1==bok2){
          return this.bok1 * this.bok3;
//        }
//        else{
//          return this.bok1 * this.bok2;
//        }
    }
}