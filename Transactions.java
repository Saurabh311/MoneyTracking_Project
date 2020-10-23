package moneytrackerapp;

import java.io.Serializable;
import java.util.Comparator;

public class Transactions implements Serializable {
    String tittle; // Description of transaction
    int month;  // month of transaction
    int amount;
    String type; // expense or income

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

class SortByAmount implements Comparator<Transactions> {
    // used for ascending order of amount
    @Override
    public int compare(Transactions a, Transactions b ){
        return a.getAmount() - b.getAmount();
    }

}

class SortByMonth implements Comparator<Transactions> {
    // used for ascending order of amount
    @Override
    public int compare(Transactions a, Transactions b) {
        return a.getMonth() - b.getMonth();
    }
}

class SortByType implements Comparator<Transactions> {
    // used for ascending order of amount
    @Override
    public int compare(Transactions a, Transactions b) {
        return a.type.compareTo(b.type);
    }
}