package equals_hashcode;

import java.util.Objects;

public class MoneyNew {
    int amount;
    String currency;

    public MoneyNew(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    /**
     * Equals contract that we should preserve
     * <p>
     * reflexive: an object must equal itself
     * symmetric: x.equals(y) must return the same result as y.equals(x)
     * transitive: if x.equals(y) and y.equals(z), then also x.equals(z)
     * consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)
     * <p>
     * <p>
     * Objects that are equal (according to their equals())
     * must return the same hash code. Different objects do not need to return different hash codes.
     *
     * @param o
     * @return
     */
    @Override
    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MoneyNew))
            return false;

        MoneyNew other = (MoneyNew) o;
        boolean currencyCodeEquals = (this.currency == null && other.currency == null)
                || (this.currency != null && this.currency.equals(other.currency));
        return this.amount == other.amount && currencyCodeEquals;
    }

//    @Override
//    public int hashCode() {
//        return amount * currency.hashCode();
//    }





    /**
     * Hash code contract
     *
     * internal consistency: the value of hashCode() may only change if a property that is in equals() changes
     * equals consistency: objects that are equal to each other must return the same hashCode
     * collisions: unequal objects may have the same hashCode
     *
     * The hashCode() method defined by class Object does return distinct integers for distinct objects.
     * (This is typically implemented by converting the internal address of the object into an integer
     * @return
     */
    @Override
    public final int hashCode() {
        return Objects.hash(amount, currency);
    }
}
