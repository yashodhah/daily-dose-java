package equals_hashcode;

import equals_hashcode.Money;
import equals_hashcode.MoneyNew;
import equals_hashcode.MoneyRecord;
import equals_hashcode.Voucher;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.simple().forClass(MoneyNew.class).verify();
    }

    @Test
    public void test1() {
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        Assertions.assertFalse(income.equals(expenses));
        Assertions.assertFalse(income.hashCode() == expenses.hashCode());
    }


    @Test
    public void test2() {
        MoneyNew income = new MoneyNew(55, "USD");
        MoneyNew expenses = new MoneyNew(55, "USD");

        Assertions.assertTrue(income.equals(expenses));
        Assertions.assertTrue(income.hashCode() == expenses.hashCode());
    }

    @Test
    public void test3() {
        MoneyRecord income = new MoneyRecord(55, "USD");
        MoneyRecord expenses = new MoneyRecord(55, "USD");

        Assertions.assertTrue(income.equals(expenses));
        Assertions.assertTrue(income.hashCode() == expenses.hashCode());
    }

    @Test
    public void test4() {
        Money money = new Money(55, "USD");

        Voucher voucher1 = new Voucher(55, "USD", "STORE1");
        Voucher voucher2 = new Voucher(55, "USD", "STORE1");
        Voucher voucher3 = new Voucher(55, "USD", "STORE2");

        Assertions.assertTrue(voucher1.equals(voucher2));
        Assertions.assertTrue(voucher1.hashCode() == voucher2.hashCode());

        Assertions.assertFalse(money.equals(voucher1));
        Assertions.assertFalse(voucher1.equals(voucher3));
    }
}
