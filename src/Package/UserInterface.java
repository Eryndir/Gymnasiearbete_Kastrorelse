package Package;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    FormelMetoder fm;

    public UserInterface(Scanner scanner, FormelMetoder fm) {
        //UIn tar emot en scanner, som läser igenom konsolen, 
        //och ett Formel-objekt, som den kan räkna på
        this.scanner = scanner;
        this.fm = fm;
    }
    
    public void start() {
        System.out.print("Hastighet: ");
        fm.setV0(scanner.nextDouble()); //läser nästa double som inmatas i konsolen som vinkeln för hastigheten
        System.out.print("Vinkel: ");
        fm.setVinkel(scanner.nextDouble()); //läser nästa double som inmatas i konsolen som vinkeln för formeln
        System.out.print("Tyngdaccelerationen: ");
        fm.setG(scanner.nextDouble());//läser nästa double som inmatas i konsolen som tyngdaccelerationen
        System.out.print("Antal steg som visas: "); 
        GrafRitare gf = new GrafRitare(fm); //skapar grafritar-objektet
        gf.positionRaknare(scanner.nextInt());
        //läser nästa int som inmatas i konsolen som antal steg som ska räknas 
        //och räknar ut alla steg med de variabler som inmatats
    }
    
    public void startluftmotstand() {
        System.out.print("Hastighet: ");
        fm.setV0(scanner.nextDouble()); //läser nästa double som inmatas i konsolen som vinkeln för hastigheten
        System.out.print("Vinkel: ");
        fm.setVinkel(scanner.nextDouble()); //läser nästa double som inmatas i konsolen som vinkeln för formeln
        System.out.print("luftmotståndskoefficienten: ");
        fm.setC(scanner.nextDouble());
        System.out.print("luftens densitet: ");
        fm.setP(scanner.nextDouble());
        System.out.print("föremålets tvärsnittsarea: ");
        fm.setA(scanner.nextDouble());
        System.out.println(fm.k());
        System.out.println(fm.xHastighet());
        System.out.println(fm.xAcceleration());
    }
}
