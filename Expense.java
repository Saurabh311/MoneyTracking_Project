package Shapes;

import java.io.Serializable;

public class Expense extends Transactions implements Serializable {
    public Expense( String tittle, int month, int amount){
        setMonth(month);
        setAmount(amount);
        setTittle(tittle);
        setType("Expenses");
    }
}
