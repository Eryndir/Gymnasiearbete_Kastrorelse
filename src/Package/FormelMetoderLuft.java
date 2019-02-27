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
     * Detta är luftmotståndskoefficienten
     */
    public double c;

    /**
     * Detta är luftens densitet, är 1,2041 kg/m3 i vanlig luft
     */
    public double p;

    /**
     * Föremålets tvärsnittsarea
     */
    public double a;

    /**
     * Föremålets massa
     */
    protected double m;

    /**
     * Acceleration i x-led
     */
    protected double xAcceleration;

    /**
     * Acceleration i y-led
     */
    protected double yAcceleration;

    /**
     * Returnerar luftmotståndskoefficienten
     *
     * @return luftmotståndet
     */
    public double getK() {
        return k;
    }

    /**
     * Bestämmer luftmotståndet
     *
     * @param k Det valda luftmotstånds värdet
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * Returnerar luftmotståndskoefficienten
     *
     * @return luftmotståndskoefficienten
     */
    public double getC() {
        return c;
    }

    /**
     * Bestämmer luftmotståndskoefficienten
     *
     * @param c Den valda luftmotståndskoefficienten
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Returnerar densitetet
     *
     * @return densitet
     */
    public double getP() {
        return p;
    }

    /**
     * Bestämmer densitetet
     *
     * @param p Det valda densitetet
     */
    public void setP(double p) {
        this.p = p;
    }

    /**
     * Returnerar tvärsnittsarea
     *
     * @return tvärsnittsarea
     */
    public double getA() {
        return a;
    }

    /**
     * Bestämmer tvärsnittsarea
     *
     * @param a Den valda tvärsnittsarea
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Returnerar massan
     *
     * @return massan
     */
    public double getMassa() {
        return m;
    }

    /**
     * Bestämmer massan
     *
     * @param m Den valda massan
     */
    public void setMassa(double m) {
        this.m = m;
    }

    /**
     * Räknar ut luftmotståndet med formeln (c*p*a)/(2m) där c =
     * luftmotståndskoefficienten, p = luftens densitet, a = föremålets
     * tvärsnittsarea och m = föremålets massa
     *
     * @return Luftotståndet
     */
    public double k() {
        return k = (c * p * a) / (2 * m);
    }

    /**
     * Räknar ut accelerationen i x-led enligt en stegmetod. Formeln är 
     * Axn = -k * Vn * Vxn, där n är det nuvarande steget
     *
     * @param v totala hastigheten från föregående steg
     * @param vx hastigheten i x-led från föregående steg
     * @return acceleration i x-led
     */
    public double xAcceleration(double v, double vx) {
        return xAcceleration = -k() * v * vx;
    }

    /**
     * Räknar ut accelerationen i y-led enligt en stegmetod. Formeln är Ayn =
     * -g-k*Vn*Vyn, där n är det nuvarande steget
     *
     * @param v totala hastigheten från föregående steg
     * @param vy hastigheten i y-led från föregående steg
     * @return acceleration i y-led
     */
    public double yAcceleration(double v, double vy) {
        //formlen är ay = -g * (((0.5) * c * p * a * V2) * V )/ m) * Vy

        return yAcceleration = -(k * v * vy) - g;
    }

    /**
     * Räknar ut positionen av föremålet i x-led enligt en stegmetod. Formeln 
     * är Xn = Xn-1 + Vxn-1 * deltaT, där m är det nuvarande steget och 
     * n-1 är det föregående steget
     *
     * @param x positionen i x-led från föregående steg
     * @param vx hastiheten i x-led från föregående steg
     * @param deltaT tidsskillnaden mellan varje steg
     * @return X-positionen
     */
    public double xPositionLuft(double x, double vx, double deltaT) {
        return x + (vx * deltaT);
    }

    /**
     * Räknar ut positionen av föremålet i y-led enligt en stegmetod. Formeln 
     * är Yn = Yn-1 + Yxn-1 * deltaT, där n är det nuvarande steget och 
     * n-1 är det föregående steget
     *
     * @param y positionen i Y-led från föregående steg
     * @param vy hastigheten i y-led från föregående steg
     * @param deltaT tidsskillnaden mellan farje steg
     * @return Y-positionen
     */
    public double yPositionLuft(double y, double vy, double deltaT) {
        return y + (vy * deltaT);
    }

    /**
     * Räknar ut hastigheten av föremålet i x-led enligt enstegmetod. Formeln 
     * är Vxn = Vxn-1 + Axn-1 * t, där n är det nuvarande steget och n-1 
     * är det föregående steget
     *
     * @param vx hastigheten i x-led från föregående steg
     * @param ax acceleration i x-led från föregående steg
     * @param deltaT tidsskillnaden mellan farje steg
     * @return hastigheten i x-led med luftmotstånd
     */
    public double xHastighetLuft(double vx, double ax, double deltaT) {
        return vx + (ax * deltaT);
    }

    /**
     * Räknar ut hastigheten av föremålet i x-led enligt enstegmetod. Formeln
     * är Vyn = Vyn-1 + Ayn-1 * t, där n är det nuvarande steget och n-1 
     * är det föregående steget
     *
     * @param vy
     * @param ay
     * @param deltaT tidsskillnaden mellan farje steg
     * @return
     */
    public double yHastighetLuft(double vy, double ay, double deltaT) {
        return vy + (ay * deltaT);
    }
}
