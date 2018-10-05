package package;
    public class FormelMetoder {
    
    //Vet ej om double är bättre än int eller tvärtom.. antar att det är double i detta fallet
    
    
    private double xStartHastighet; //Detta är V0x
    private double yStartHastighet; //Detta är V0y
    
    private double xHastighet; //Detta är hastigheten i x-led
    private double yHastighet; //Detta är hastigheten i y-led
    
    private double xPosition; //Detta är positionen i x-led
    private double yPosition; //Detta är positionen i y-led
    
    private double V0; //Får skriva V0 i formlerna sålänge, sen får man ändra så att användaren skriver in värdena
    private double Vinkel; //Denna får man också ändra längre fram så att användaren kan skriva in vinkeln
    
   
    private double t; //Är också en variabel som behöver ändras så att användaren skriver in värdet
    private double g; //Är helt enkelt 9.82 m/s, man kan också göra denna så att användaren skriver in en egen gravitation,
    //t.ex om man skulle vilja kasta på månen (?)                        
  

    public void xStartHastighet(){
        
        // Formeln är V0x = V0 * cosV
        // V0x = xStartHastighet
        
        xStartHastighet = V0 * Math.cos(Vinkel);
    }

   
    public void yStartHastighet(){
        
        // Formeln är V0y = V0 * sinV
        // V0y = yStarthastighet
    
        yStartHastighet = V0 * Math.sin(Vinkel);
    }


    public void xHastighet(){
        
        // Formeln är Vx = V0x
        // blir alltså samma som xStartHastighet
    
        xHastighet = V0 * Math.cos(Vinkel);
    }
    
    public void yHastighet(){
        
        //Formeln är Vy = V0y - g * t
        double g = 9.82;
        
        yHastighet = yStartHastighet - g * t;
    }
    
    public void xPosition(){
        //Formeln är x = V0x * t
        
        xPosition = xStartHastighet * t;
    }
    
    
    public void yPosition(){
        //Formeln är y = V0y * t - (g * t2)/2
        //t2 är alltså t upphöjt med 2 
        
        yPosition = yStartHastighet * t - (g * (t*t)/2);
    }
    
    
    }
