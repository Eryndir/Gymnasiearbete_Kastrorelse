package Package;

public class FormelMetoder {

    //vå bör leta upp formler till kaströrelser med luftmåtstånd senare
    protected double xStartHastighet; //Detta är V0x
    protected double yStartHastighet; //Detta är V0y

    protected double xHastighet; //Detta är hastigheten i x-led
    protected double yHastighet; //Detta är hastigheten i y-led
    protected double sammanlagtHastighet;
    //Detta är hastigheten i båda hastigheter tllsammans

    protected double xPosition; //Detta är positionen i x-led
    protected double yPosition; //Detta är positionen i y-led
    protected double yStartPosition; //Detta är startpositionen i y-led

    protected double V0; //Starthastigheten
    protected double Vinkel; //Kastvinkeln

    protected double t = 0; //Tid, som börjar vid 0 sekunder
    protected double g; //Tyngdaccelerationen          

    public void setV0(double V0) {
        this.V0 = V0; // inamta starthastighet
    }

    public double getV0() {
        return V0;
    }

    public void setVinkel(double Vinkel) {
        this.Vinkel = Math.toRadians(Vinkel);
        //Bestämmer grader
        //översätts från grader till radianer
    }

    public void setT(double t) {
        this.t = t; //inmata tid
    }

    public void setG(double g) {
        this.g = g; //inmata gravitationsacceleration
    }

    public void setyStartPosition(double yStartPosition) {
        this.yStartPosition = yStartPosition; //inmata startposition i y-led
    }

    public double getT() {
        return t; //ger ut tiden
    }

    public double getG() {
        return g; // ger ut tyngdaccelerationen
    }

    public double getyStartPosition() {
        return yStartPosition;
    }

    public void adderaT(double term) {
        this.t += term;
        //adderar en viss mängd på den tid som har blivit inmatad, 
        //om tid inte är definierat ännu adderas parametern på noll
    }

    public double xStartHastighet() {
        // Formeln är Vx0 = V0 * cosV
        // V0x = xStartHastighet
        // Räknar ut starthastighet i x-led
        return xStartHastighet = V0 * Math.cos(Vinkel);
    }

    public double yStartHastighet() {

        // Formeln är V0y = V0 * sinV
        // V0y = yStarthastighet
        // Räknar ut starthastighet i y-led
        return yStartHastighet = V0 * Math.sin(Vinkel);
    }

    public double xHastighet() {

        // Formeln är Vx = V0x
        // blir alltså samma som xStartHastighet då 
        // inga kraften verkar mot föremålet i x-led
        return xHastighet = V0 * Math.cos(Vinkel);
    }

    public double yHastighet() {

        //Formeln är Vy = V0y - g * t
        //räknar ut hastihet i y-led
        return yHastighet = yStartHastighet() - g * t;
    }

    public double xPosition() {
        //Formeln är x = V0x * t
        //räknar ut positionen i x-led
        return xPosition = xStartHastighet() * t;
    }

    public double yPosition() {
        //Formeln är y = V0y * t - (g * t2)/2
        //t2 är alltså t upphöjt med 2 
        //räknar ut positionen i y-led
        return yPosition = yStartHastighet() * t - (g * (t * t) / 2);
    }

    public double sammanlagtHastighet(double xHastighet, double yHastighet) {
        //Formeln är v = √V0x2+V0y2
        //alltså roten ur V0x upphöjt i två + V0y upphöjt i två 
        //räknar ut den sammanlagda hastigheten
        return sammanlagtHastighet = Math.sqrt(Math.pow(xHastighet, 2) 
                + Math.pow(yHastighet, 2));
    }

    public double totalaTid() {

        double pqFormalDel1 = (yStartHastighet() / (g / 2)) / 2; 
        // första halvan av pq - formeln
        double pqFormelDel2 = Math.sqrt(Math.pow(pqFormalDel1, 2) 
                + (yStartPosition / (g / 2))); // andra halvan av pq-formeln

        return pqFormalDel1 + pqFormelDel2; //räknar ut den totala kasttiden
    }

    public double yMax() {
        return (int) ((Math.pow(V0, 2) * Math.pow(Math.sin(Vinkel), 2)) 
                / (2 * g)) + yStartPosition;
    }

    public double xMax() {
        return (int) ((Math.pow(V0, 2) * Math.sin(2 * Vinkel)) / g);
    }
}
