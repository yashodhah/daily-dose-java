package equals_hashcode;

public class Voucher {
    private MoneyNew value; // Rather than extending use composition
    private String store;

    public Voucher(int amount, String currencyCode, String store) {
        this.value = new MoneyNew(amount, currencyCode);
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voucher))
            return false;

        Voucher other = (Voucher) o;
        boolean valueEquals = (this.value == null && other.value == null)
                || (this.value != null && this.value.equals(other.value));
        boolean storeEquals = (this.store == null && other.store == null)
                || (this.store != null && this.store.equals(other.store));

        return valueEquals && storeEquals;
    }
}
