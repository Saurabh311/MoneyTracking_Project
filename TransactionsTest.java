package moneytrackerapp;
import junit.framework.TestCase;

public class TransactionsTest extends TestCase {

    public void testSetGetAmount() {
        int amount = 2000;
        Transactions transcation = new Transactions();
        transcation.setAmount(amount);
        int result = transcation.getAmount();
        assertEquals(amount, result);
    }

    public void testSetGetTittle() {
        String tittle = "Ikea Shopping";
        Transactions transcation = new Transactions();
        transcation.setTittle(tittle);
        String result = transcation.getTittle();
        assertEquals(tittle, result);
    }

    public void testSetGetMonth() {
        int month = 1;
        Transactions transcation = new Transactions();
        transcation.setMonth(month);
        int result = transcation.getMonth();
        assertEquals(month, result);
    }

    public void testSetGetType() {
        String type = "Income";
        Transactions transcation = new Transactions();
        transcation.setTittle(type);
        String result = transcation.getTittle();
        assertEquals(type, result);
    }
}