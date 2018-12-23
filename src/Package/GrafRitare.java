package Package;
import java.util.*;
public class GrafRitare {

    FormelMetoder fm;
    ArrayList<Integer> xkoordinater;
    ArrayList<Integer> ykoordinater;
    double Zoom;
    
    public GrafRitare(FormelMetoder fm, double Zoom) {
        this.fm = fm;
        this.Zoom = Zoom;
    }

    // i positionräknaren ska det finnas en metod senare som ritar på en panel prickar vid de olika positioner
    public ArrayList positionRaknare(int antalSteg) { //räknar ut alla positioner vid alla steg som inmatas
        ArrayList array = new ArrayList();
        xkoordinater = new ArrayList();
        ykoordinater = new ArrayList();
        int indrag = 50;
        
        array.add("steg\tx\ty\ttid" + 
                "\n0\t0.0\t" + this.fm.getyStartPosition() + "\t0");
        
        xkoordinater.add(0+indrag);
        ykoordinater.add((int)this.fm.getyStartPosition()+indrag);
        
        double x;
        double y;
        int steg = antalSteg;
        double t = this.fm.totalaTid() / steg; //skillnaden på t för varje steg; delta t

        for (int i = 1; i <= steg; i++) { //loop som går runt så många gånger som inmatas i antalSteg
            this.fm.adderaT(t); //adderar delta t på den tid som gått
            x = Zoom * this.fm.xPosition(); //räknar ut x-positionen vid t
            y = Zoom * (this.fm.yPosition() + this.fm.getyStartPosition()); //räknar ut y-positionen vid t och adderar startpositionen, annars går kasten från origo till -startpositon, t.ex 0 till -30 istället för 30 till 0
            
            xkoordinater.add((int)x+indrag);
            ykoordinater.add((int)y+indrag);
            
            
            array.add("" + avrundning(i) + "\t" + avrundning(x) + "\t" + avrundning(y) + "\t" + avrundning(this.fm.getT()));
        }
        return array;
    }
    
    public String resultatOutout(ArrayList resultat) {
        String resultatLista = "";
        for (Object string : resultat) {
            resultatLista += string + "\n";
        }
        return resultatLista;
    }

    public void positionRaknareLuftMotstand(int antalSteg) {
        double x;
        double y;
        int steg = antalSteg;
        double t = this.fm.totalaTid() / steg;

        System.out.println("steg\tx\ty\ttid");
        System.out.println("0\t0.0\t" + this.fm.getyStartPosition() + "\t0");
        for (int i = 1; i <= steg; i++) {
            this.fm.adderaT(t);
            
        }
    }

    public double avrundning(double tal) { //avrundar, antal nollar avgår hur många decimaler som metodenavrundar till
        return (double) Math.round(tal * 1000d) / 1000d;
    }
}
