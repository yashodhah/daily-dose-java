package equals_hashcode;

public class MoneyNew  {
    int amount;
    String currency;

    public MoneyNew(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    /**
     * reflexive: an object must equal itself
     * symmetric: x.equals(y) must return the same result as y.equals(x)
     * transitive: if x.equals(y) and y.equals(z), then also x.equals(z)
     * consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MoneyNew))
            return false;

        MoneyNew other = (MoneyNew) o;
        boolean currencyCodeEquals = (this.currency == null && other.currency == null)
                || (this.currency != null && this.currency.equals(other.currency));
        return this.amount == other.amount && currencyCodeEquals;
    }
}
