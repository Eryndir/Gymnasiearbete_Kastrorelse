package Package;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        FormelMetoder fm = new FormelMetoder(); //skapar Formels
        Scanner scanner = new Scanner(System.in); //skapar scannaren som läser i konsolen, kommer försvinna när den grafiska delen är gjord
        UserInterface ui = new UserInterface(scanner, fm); //skapar en UserInterface
        
        ui.start(); //startar userinterfacet
        //ui.startluftmotstand();
    }
    
}
