package Package;
import java.util.*;
public class GrafRitare {

    FormelMetoder fm;
    FormelMetoderLuft fmLuft;
    ArrayList<Integer> xkoordinater;
    ArrayList<Integer> ykoordinater;
    ArrayList<Integer> xkoordinaterLuft;
    ArrayList<Integer> ykoordinaterLuft;
    double Zoom;
    
    public GrafRitare(FormelMetoder fm, double Zoom) {
        this.fm = fm;
        this.Zoom = Zoom;
    }
    
    public GrafRitare(FormelMetoderLuft fmLuft, double Zoom) {
        this.fmLuft = fmLuft;
        this.Zoom = Zoom;
    }

    // i positionräknaren ska det finnas en metod senare som ritar på en panel prickar vid de olika positioner
    public ArrayList positionRaknare(int antalSteg) { //räknar ut alla positioner vid alla steg som inmatas
        
        ArrayList array = new ArrayList(); //en lista där alla värden sparas
        xkoordinater = new ArrayList(); //en lista med endast xkoordinater för att rita med
        ykoordinater = new ArrayList(); // en lista med endast ykoordinater för att rita med
        int indrag = 50; //hur långt från kanten av rutan grafen är
        
        //start värdena av kasten läggs in i array listan
        array.add("steg\tx\ty\ttid" + 
                "\n0\t0.0\t" + this.fm.getyStartPosition() + "\t0");
        
        xkoordinater.add(0+indrag); //xkoordinaters startvärde när de ska ritas; börjar på 0, men ska ritas 50 från kanten
        ykoordinater.add((int)(this.fm.getyStartPosition()*Zoom)+indrag); //indraget är densamma som ovan
        
        double x;
        double y;
        int steg = antalSteg;
        double t = this.fm.totalaTid() / steg; //skillnaden på t för varje steg; delta t

        for (int i = 1; i <= steg; i++) { //loop som går runt så många gånger som inmatas i antalSteg
            this.fm.adderaT(t); //adderar delta t på den tid som gått
            x = Zoom * this.fm.xPosition(); //räknar ut x-positionen vid t
            y = Zoom * (this.fm.yPosition() + this.fm.getyStartPosition()); //räknar ut y-positionen vid t och adderar startpositionen, annars går kasten från origo till -startpositon, t.ex 0 till -30 istället för 30 till 0
            
            xkoordinater.add((int)x+indrag); //anpassar grafen till ritning
            ykoordinater.add((int)y+indrag); //samma som ovan
            
            //avrumdar värdena och läggar in dem i arraylistan som ska visas up för användaren
            array.add("" + avrundning(i)*Zoom + "\t" + avrundning(x) + "\t" + avrundning(y) + "\t" + avrundning(this.fm.getT()*Zoom));
        }
        return array;
    }
    
    //metod som läser attaylistan och översätter den för JList som användaren kan läsa
    public String resultatOutout(ArrayList resultat) { 
        String resultatLista = "";
        for (Object string : resultat) {
            resultatLista += string + "\n";
        }
        return resultatLista;
    }
    
    //Luftmotsåtnd inte klart ännu
    public ArrayList positionRaknareLuftMotstand(int antalSteg) {
        ArrayList arrayLuft = new ArrayList();
        xkoordinaterLuft = new ArrayList();
        ykoordinaterLuft = new ArrayList();
        int indrag = 50;
        
        arrayLuft.add("steg\tx\ty\ttid" + 
                "\n0\t0.0\t" + this.fmLuft.getyStartPosition() + "\t0");
        
        xkoordinater.add(0+indrag);
        ykoordinater.add((int)this.fmLuft.getyStartPosition()+indrag);
        
        double x = 0;
        double y = this.fmLuft.getyStartPosition();
        
        int steg = antalSteg;
        double t = this.fmLuft.totalaTid() / steg; //skillnaden på t för varje steg; delta t

        for (int i = 1; i <= steg; i++) { //loop som går runt så många gånger som inmatas i antalSteg
            this.fmLuft.adderaT(t); //adderar delta t på den tid som gått
            
            x = Zoom * this.fmLuft.xPositionLuft(x, x, t);
            y = Zoom * this.fmLuft.yPositionLuft(y, y, t);
            
            xkoordinater.add((int)x+indrag);
            ykoordinater.add((int)y+indrag);
            
            
            arrayLuft.add("" + avrundning(i) + "\t" + avrundning(x) + "\t" + avrundning(y) + "\t" + avrundning(this.fm.getT()));
        }
        return arrayLuft;
    }

    public double avrundning(double tal) { //avrundar, antal nollar avgår hur många decimaler som metodenavrundar till
        tal = tal/Zoom;
        return (double) Math.round(tal * 1000d) / 1000d;
    }
}
