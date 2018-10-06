package Package;

public class GrafRitare {
    FormelMetoder fm;

    public GrafRitare(FormelMetoder fm) {
        this.fm = fm;
    }
    // i positionräknaren ska det finnas en metod senare som ritar på en panel prickar vid de olika positioner
    public void positionRaknare(int antalSteg) { //räknar ut alla positioner vid alla steg som inmatas
        double x; double y;
        int steg = antalSteg;
        double t = this.fm.totalaTid()/steg; //skillnaden på t för varje steg; delta t
        
        System.out.println("steg\tx\ty\ttid"); 
        System.out.println("0\t0,0\t0,0\t0");
        for (int i = 1; i <= steg; i++) { //loop som går runt så många gånger som inmatas i antalSteg
            this.fm.adderaT(t); //adderar delta t på den tid som gått
            x = this.fm.xPosition(); //räknar ut x-positionen vid t
            y = this.fm.yPosition(); //räknar ut y-positionen vid t
            //här ska draw() läggas metoden senare
            System.out.println(avrundning(i) + "\t" + avrundning(x) + "\t" + avrundning(y) + "\t" + avrundning(this.fm.getT())); //skriver ut resultatet vid t
        }
    }
    
    public double avrundning(double tal) { //avrundar, antal nollar avgår hur många decimaler som metodenavrundar till
        return (double)Math.round(tal * 1000d)/1000d;
    }
}
