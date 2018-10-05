/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *kappa
 * @author Edvin
 */
public class Main {
    
    public static void main(String[] args) {
        FormelMetoder fm = new FormelMetoder();
        
        fm.setT(0.4);
        fm.setVinkel(30);
        fm.setV0(10);
        fm.setG(9.82);
        
        System.out.println(fm.xPosition());
        System.out.println(fm.yPosition());
        System.out.println(fm.xHastighet());
        System.out.println(fm.yHastighet());
        System.out.println(fm.sammanlagtHastighet());
    }
    
}
