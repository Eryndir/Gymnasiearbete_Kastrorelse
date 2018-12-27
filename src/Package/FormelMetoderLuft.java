package Package;

public class FormelMetoderLuft {

    //vå bör leta upp formler till kaströrelser med luftmåtstånd senare
    private double xStartHastighet; //Detta är V0x
    private double yStartHastighet; //Detta är V0y

    private double xHastighet; //Detta är hastigheten i x-led
    private double yHastighet; //Detta är hastigheten i y-led
    private double sammanlagtHastighet; //Detta är hastigheten i båda hastigheter tllsammans

    private double xPosition; //Detta är positionen i x-led
    private double yPosition; //Detta är positionen i y-led
    private double yStartPosition; //Detta är startpositionen i y-led

    private double V0; //Får skriva V0 i formlerna sålänge, sen får man ändra så att användaren skriver in värdena
    private double Vinkel; //Denna får man också ändra längre fram så att användaren kan skriva in vinkeln

    public double k; //Detta är luftmotståndet
    public double c; //Detta är luftmotståndskoefficienten
    public double p; //Detta är luftens densitet, är 1,2041 kg/m3 i vanlig luft
    public double a; //Föremålets tvärsnittsarea

    private double m; //massa
    private double t = 0; //Är också en variabel som behöver ändras så att användaren skriver in värdet
    private double g; //Är helt enkelt 9.82 m/s, man kan också göra denna så att användaren skriver in en egen gravitation,
    //t.ex om man skulle vilja kasta på månen (?)                        

    private double xAcceleration;
    private double yAcceleration;

    public void setV0(double V0) {
        this.V0 = V0; // inamta starthastighet
    }

    public void setVinkel(double Vinkel) {
        this.Vinkel = Math.toRadians(Vinkel); //översätts från grader till radianer
    }

    public void setT(double t) {
        this.t = t; //inmata tid
    }

    public void setG(double g) {
        this.g = g; //inmata gravitationsacceleration
    }

    public void setC(double c) {
        this.c = c; //inmata luftmotståndskoefficienten
    }

    public void setP(double p) {
        this.p = p; //inmata luftens densitet
    }

    public void setA(double a) {
        this.a = a; //inmata tvärsnittsarea
    }

    public void setMassa(double massa) {
        this.m = massa; //inmata massa
    }

    public void setyStartPosition(double yStartPosition) {
        this.yStartPosition = yStartPosition;
    }

    public double getT() {
        return t; //ger ut tiden
    }

    public double getG() {
        return g; // ger ut tyngdaccelerationen
    }

    public double getC() {
        return c; // ger ut luftmotståndskoefficienten
    }

    public double getp() {
        return p; // ger ut luftens densitet
    }

    public double getA() {
        return a; // ger ut Föremålets tvärsnittsarea
    }

    public double getMassa() {
        return m; // ger ut Föremålets massa
    }

    public double getyStartPosition() {
        return yStartPosition;
    }

    public void adderaT(double term) {
        this.t += term;
        // adderar en viss mängd på den tid som har blivit inmatad, om tid inte är definierat ännu adderas termen med noll
    }

    public double xStartHastighet() {

        // Formeln är V0x = V0 * cosV
        // V0x = xStartHastighet
        return xStartHastighet = V0 * Math.cos(Vinkel);
    }

    public double yStartHastighet() {

        // Formeln är V0y = V0 * sinV
        // V0y = yStarthastighet
        return yStartHastighet = V0 * Math.sin(Vinkel);
    }

    public double xHastighet() {

        // Formeln är Vx = V0x
        // blir alltså samma som xStartHastighet
        return xHastighet = V0 * Math.cos(Vinkel);
    }

    public double yHastighet() {

        //Formeln är Vy = V0y - g * t
        double g = 9.82;

        return yHastighet = yStartHastighet() - g * t;
    }

    public double xPosition() {
        //Formeln är x = V0x * t

        return xPosition = xStartHastighet() * t;
    }

    public double yPosition() {
        //Formeln är y = V0y * t - (g * t2)/2
        //t2 är alltså t upphöjt med 2 

        return yPosition = yStartHastighet() * t - (g * (t * t) / 2);
    }

    public double sammanlagtHastighet() {
        //Formeln är v = √V0x2+V0y2
        //alltså roten ur V0x upphöjt i två + V0y upphöjt i två 

        return sammanlagtHastighet = Math.sqrt(Math.pow(xHastighet(), 2) + Math.pow(yHastighet(), 2));
    }

    public double totalaTid() {

        double pqFormalDel1 = (yStartHastighet() / (g / 2)) / 2; // första halvan av pq - formeln
        double pqFormelDel2 = Math.sqrt(Math.pow(pqFormalDel1, 2) + (yStartPosition / (g / 2))); // andra halvan av pq-formeln

        return pqFormalDel1 + pqFormelDel2; //räknar ut den totala kasttiden
    }

    public double yMax() {
        return (int) ((Math.pow(V0, 2) * Math.pow(Math.sin(Vinkel), 2))/ (2 * g)) + yStartPosition;
    }
    
    public double xMax() {
        return (int) ((Math.pow(V0, 2) * Math.sin(2*Vinkel))/ g);
    }
    
    //Här börjar formlerna för Luftmotstånd
    public double k() {
        //Formeln är F = 1/2 * c * p * a * V2
        //(k = F)
        //c = luftmotståndskoefficienten
        //p = luftens densitet
        //a = föremålets tvärsnittsarea

        return k = (0.5) * c * p * a * Math.pow(V0, 2); //räknar ut luftmotståndet 

    }
    
    public double xAccelerationbegynnelse() {
        //formlen är aX = (((0.5) * c * p * a * V2) * V )/ m) * Vx

        return xAcceleration = -((k() * xHastighet()) / (m)) * xHastighet();//ska räkna ut accelerationen i xled till luftmotståndet
    }

    public double yAccelerationbegynnelse() {
        //formlen är ay = -g * (((0.5) * c * p * a * V2) * V )/ m) * Vy

        return yAcceleration = -g * ((((k) * (yHastighet())) / (m)) * (yHastighet));//ska räkna ut accelerationen i yled till luftmotståndet
    }

    public double xAcceleration() {
        //formlen är aX = (((0.5) * c * p * a * V2) * V )/ m) * Vx

        return xAcceleration = -((k() * sammanlagtHastighet()) / (m)) * xHastighet();//ska räkna ut accelerationen i xled till luftmotståndet
    }

    public double yAcceleration() {
        //formlen är ay = -g * (((0.5) * c * p * a * V2) * V )/ m) * Vy

        return yAcceleration = -g * ((((k) * (sammanlagtHastighet())) / (m)) * (yHastighet));//ska räkna ut accelerationen i yled till luftmotståndet
    }
    
    public double xPositionLuft(double x, double vx, double t) {
        return x+vx*t;
    }
    
    public double yPositionLuft(double y, double vy, double t) {
        return y+vy*t;
    }
    
    public double xHastughetLuft(double vx, double ax, double tid) {
        return vx + ax * tid;
    }
    
    public double yHadtighetLuft(double vy, double ay, double tid) {
        return vy + ay * tid;
    }

}
