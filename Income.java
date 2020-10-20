package Shapes;

import java.io.Serializable;

public class Income extends Transactions implements Serializable {
    public Income (String tittle, int month, int amount){
        setMonth(month);
        setAmount(amount);
        setTittle(tittle);
        setType("Income");

    }

}
