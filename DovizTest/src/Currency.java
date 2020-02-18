public class Currency
{

    private String code;
    private int unit;
    private String name;
    private String currencyName;
    private double forexBuying;
    private double forexSelling;
    private double banknoteBuying;
    private double banknoteSelling;

    public Currency(String code, int unit, String name, String currencyName, double forexBuying, double forexSelling, double banknoteBuying, double banknoteSelling)
    {
        this.code = code;
        this.unit = unit;
        this.name = name;
        this.currencyName = currencyName;
        this.forexBuying = forexBuying;
        this.forexSelling = forexSelling;
        this.banknoteBuying = banknoteBuying;
        this.banknoteSelling = banknoteSelling;
    }

    @Override
    public String toString()
    {
        return String.format("%s %d %s %s %.5f %.5f %.5f %.5f", code, unit, name, currencyName, forexBuying, forexSelling, banknoteBuying, banknoteSelling);
    }
}