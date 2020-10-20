package Shapes;

import java.io.Serializable;

public class Transactions implements Serializable {
    private String tittle; // Description of transaction
    private int month;  // month of transaction
    private int amount;
    private String type; // expense or income

    public Transactions(String tittle, int month, int amount, String type){
        this.tittle = tittle;
        this.month = month;
        this.amount = amount;
        this.type = type;
    }
    // Default Constructor
    public Transactions (){
        this.tittle = "";
        this.month = 0;
        this.amount = 0;
        this.type = "";
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
