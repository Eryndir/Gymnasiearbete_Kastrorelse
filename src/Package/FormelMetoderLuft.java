package Package;

/**
 * Denna klass innehåller metoder och variabler för att räkna ut formler med
 * luftmotstånd. Klassen ärver av FormelMetoder och kan därefter använda alla
 * dess metoder och variabler.
 *
 * @author Edvin
 */
public class FormelMetoderLuft extends FormelMetoder {

    /**
     * Detta är luftmotståndet
     */
    public double k;

    /**
     *
     */
    public double c; //Detta är luftmotståndskoefficienten

    /**
     *
     */
    public double p; //Detta är luftens densitet, är 1,2041 kg/m3 i vanlig luft

    /**
     *
     */
    public double a; //Föremålets tvärsnittsarea

    /**
     *
     */
    protected double m; //massa   

    /**
     *
     */
    protected double xAcceleration;

    /**
     *
     */
    protected double yAcceleration;

    /**
     *
     * @return
     */
    public double getK() {
        return k;
    }

    /**
     *
     * @param k
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     *
     * @return
     */
    public double getC() {
        return c;
    }

    /**
     *
     * @param c
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     *
     * @return
     */
    public double getP() {
        return p;
    }

    /**
     *
     * @param p
     */
    public void setP(double p) {
        this.p = p;
    }

    /**
     *
     * @return
     */
    public double getA() {
        return a;
    }

    /**
     *
     * @param a
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     *
     * @return
     */
    public double getMassa() {
        return m;
    }

    /**
     *
     * @param m
     */
    public void setMassa(double m) {
        this.m = m;
    }

    /**
     *
     * @return
     */
    public double getxAcceleration() {
        return xAcceleration;
    }

    /**
     *
     * @param xAcceleration
     */
    public void setxAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    /**
     *
     * @return
     */
    public double getyAcceleration() {
        return yAcceleration;
    }

    /**
     *
     * @param yAcceleration
     */
    public void setyAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    /**
     *
     * @return
     */
    public double k() {
        //Formeln är F = 1/2 * c * p * a * V2
        //(k = F)
        //c = luftmotståndskoefficienten
        //p = luftens densitet
        //a = föremålets tvärsnittsarea

        return k = (c * p * a) / (2 * m); //räknar ut luftmotståndet 
    }

    /**
     *
     * @param v
     * @param vx
     * @return
     */
    public double xAcceleration(double v, double vx) {
        //formlen är aX = (((0.5) * c * p * a * V2) * V )/ m) * Vx

        return xAcceleration = -k() * v * vx;//ska räkna ut accelerationen i xled till luftmotståndet
    }

    /**
     *
     * @param v
     * @param vy
     * @return
     */
    public double yAcceleration(double v, double vy) {
        //formlen är ay = -g * (((0.5) * c * p * a * V2) * V )/ m) * Vy

        return yAcceleration = -(k * v * vy) - g;//ska räkna ut accelerationen i yled till luftmotståndet
    }

    /**
     *
     * @param x
     * @param vx
     * @param deltaT
     * @return
     */
    public double xPositionLuft(double x, double vx, double deltaT) {
        return x + (vx * deltaT);
    }

    /**
     *
     * @param y
     * @param vy
     * @param deltaT
     * @return
     */
    public double yPositionLuft(double y, double vy, double deltaT) {
        return y + (vy * deltaT);
    }

    /**
     *
     * @param vx
     * @param ax
     * @param deltaT
     * @return
     */
    public double xHastighetLuft(double vx, double ax, double deltaT) {
        return vx + (ax * deltaT);
    }

    /**
     *
     * @param vy
     * @param ay
     * @param deltaT
     * @return
     */
    public double yHastighetLuft(double vy, double ay, double deltaT) {
        return vy + (ay * deltaT);
    }

}
