public class Fraction implements FractionInterface {
    protected int chis;
    protected int znam;

    public Fraction(int chis, int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.chis = chis;
        this.znam = znam;
        if (znam < 0) {
            this.chis = -chis;
            this.znam = -znam;
        }
    }

    public double getDecimalValue() {
        return (double) chis / znam;
    }


    public void setChisAndZnam(int chis, int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.chis = chis;
        this.znam = znam;
        if (znam < 0) {
            this.chis = -chis;
            this.znam = -znam;
        }
    }

    public String toString() {
        return chis + "/" + znam;
    }

    public boolean equals(Object obj) {
        Fraction fraction = (Fraction) obj;
        return chis == fraction.chis && znam == fraction.znam;
    }


}