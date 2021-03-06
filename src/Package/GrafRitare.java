package Package;

import java.util.*;

public class GrafRitare {

    FormelMetoder fm;
    FormelMetoderLuft fmLuft;
    ArrayList<Integer> xkoordinater;
    ArrayList<Integer> ykoordinater;
    ArrayList<Integer> xkoordinaterLuft;
    ArrayList<Integer> ykoordinaterLuft;
    int Zoom;

    public GrafRitare(FormelMetoder fm, int Zoom) {
        this.fm = fm;
        this.Zoom = Zoom;
    }

    public GrafRitare(FormelMetoderLuft fmLuft, int Zoom) {
        this.fmLuft = fmLuft;
        this.Zoom = Zoom;
    }
    //räknar ut alla positioner vid varje tidpunkt
    public ArrayList positionRaknare(double deltaT) { 
    
        //en lista där alla värden sparas
        ArrayList array = new ArrayList(); 
        //en lista med endast xkoordinater för att rita med
        xkoordinater = new ArrayList(); 
        // en lista med endast ykoordinater för att rita med
        ykoordinater = new ArrayList(); 
        //hur långt från kanten av rutan grafen är
        int indrag = 50; 
        
        //start värdena av kasten läggs in i array listan
        array.add("steg\tx (m)\ty (m)\ttid (s)"
                + "\n0\t0.0\t" + this.fm.getyStartPosition() + "\t0");
    //xkoordinaters startvärde när de ska ritas; 
    //börjar på 0, men ska ritas 50 från kanten
        xkoordinater.add(0 + indrag); 
        //indraget är densamma som ovan
        ykoordinater.add((int) (this.fm.getyStartPosition() * Zoom) + indrag); 

        double x = 0;
        double y = 0;
        double t = deltaT; //skillnaden på t för varje steg; delta t
        int steg = 0;
        while (y >= 0) {
            this.fm.adderaT(t); //adderar delta t på den tid som gått
            x = Zoom * this.fm.xPosition(); //räknar ut x-positionen vid t
            
            //räknar ut y-positionen vid t och adderar startpositionen, 
            //annars går kasten från origo till -startpositon, 
            // t.ex 0 till -30 istället för 30 till 0
            y = Zoom * (this.fm.yPosition() + this.fm.getyStartPosition()); 

            xkoordinater.add((int) x + indrag); //anpassar grafen till ritning
            ykoordinater.add((int) y + indrag); //samma som ovan

            //avrumdar värdena och läggar in dem i arraylistan 
            //som ska visas up för användaren
            array.add("" + ++steg + "\t" + avrundning(x) + "\t" 
                    + avrundning(y) + "\t" + avrundning(this.fm.getT() 
                            * Zoom));
        }
        return array;
    }

    //metod som läser attaylistan och 
    //översätter den för JList som användaren kan läsa
    public String resultatOutout(ArrayList resultat) {
        String resultatLista = "";
        for (Object string : resultat) {
            resultatLista += string + "\n";
        }
        return resultatLista;
    }

    //metod som räknar ut alla värden av kaströrelse mrf luftmotstånd 
    //och ger ut en lista av värdena som ska visas för läsaren
    public ArrayList positionRaknareLuftMotstand(double deltaT) {
        ArrayList arrayLuft = new ArrayList();
        xkoordinaterLuft = new ArrayList();
        ykoordinaterLuft = new ArrayList();
        int indrag = 50;
        arrayLuft.add("steg\tx (m)\ty (m)\ttid (s)"
                + "\n0\t0.0\t" + this.fmLuft.getyStartPosition() + "\t0");

        xkoordinaterLuft.add(0 + indrag);
        ykoordinaterLuft.add((int) this.fmLuft.getyStartPosition() + indrag);

        double x = 0;
        double y = 0;
        double vx = this.fmLuft.xStartHastighet();
        double vy = this.fmLuft.yStartHastighet();
        double ax = this.fmLuft.xAcceleration(this.fmLuft.getV0(),
                this.fmLuft.xStartHastighet());
        double ay = this.fmLuft.yAcceleration(this.fmLuft.getV0(),
                this.fmLuft.yStartHastighet());
        double totalaV = 0;

        double t = deltaT; //skillnaden på t för varje steg; delta t
        int steg = 0;

        while (y >= 0) {
            this.fmLuft.adderaT(t); //adderar delta t på den tid som gått
            //räknar ut x-positionen vid t
            x = this.fmLuft.xPositionLuft(x, vx, t); 
            
            //räknar ut y-positionen vid t och adderar startpositionen,
            //annars går kasten från origo till -startpositon, 
            //t.ex 0 till -30 istället för 30 till 0
            y = (this.fmLuft.yPositionLuft(y, vy, t)
                    + this.fmLuft.getyStartPosition()); 

            vx = this.fmLuft.xHastighetLuft(vx, ax, t);
            vy = this.fmLuft.yHastighetLuft(vy, ay, t);

            totalaV = this.fmLuft.sammanlagtHastighet(vx, vy);

            ax = this.fmLuft.xAcceleration(totalaV, vx);
            ay = this.fmLuft.yAcceleration(totalaV, vy);

            double xkoord = (x * Zoom) + indrag;
            double ykoord = (y * Zoom) + indrag;
            xkoordinaterLuft.add((int) xkoord); //anpassar grafen till ritning
            ykoordinaterLuft.add((int) ykoord); //samma som ovan

            //avrumdar värdena och läggar in dem i arraylistan 
            //som ska visas up för användaren
            arrayLuft.add("" + ++steg + "\t" + avrundningLuft(x) + "\t" 
                    + avrundningLuft(y) + "\t" + avrundning(this.fmLuft.getT()
                            * Zoom));
        }
        return arrayLuft;
    }
    //avrundar, antal nollar avgår hur många decimaler 
    //som metoden avrundar till
    public double avrundning(double tal) { 
        tal = tal / Zoom;
        return (double) Math.round(tal * 1000d) / 1000d;
    }
    //samma som ovan, fast avsedd för grafer med luftmotstånd
    public double avrundningLuft(double tal) { 
        return (double) Math.round(tal * 1000d) / 1000d;
    }
}
