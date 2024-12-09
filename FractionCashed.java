public class FractionCashed extends Fraction{
    private Double cachedDecimalValue;
    public FractionCashed(int chis, int znam) {
        super(chis, znam);
        this.cachedDecimalValue = null;
    }
    public double getDecimalValue() {
        if (this.cachedDecimalValue == null) {
            this.cachedDecimalValue = (double) this.chis / this.znam;
        }
        return this.cachedDecimalValue;
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
        cachedDecimalValue = null;
    }
}