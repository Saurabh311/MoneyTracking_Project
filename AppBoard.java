package Shapes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
enum Transcation
{
    SHOWALLTRANSCATIONS, SHOWEXPENSES, SHOWINCOME;
}
enum Operation
{
    ADD, REMOVE, EDIT, INVALID;
}
public class AppBoard  {
    Scanner scan = new Scanner(System.in); // test

    public void showTransactions(ArrayList<Transactions> list) throws IOException, ClassNotFoundException {  // Method to see cash transaction
        System.out.println("Please select one option \n If you want to see all transactions press 1 \n if you want to see only expenses press 2 \n If you want see only Incomes press 3");
        int opt1 = scan.nextInt();
        switch (opt1) {
            case 1:
                listItem(list,Transcation.SHOWALLTRANSCATIONS);
                break;

            case 2:
                listItem(list,Transcation.SHOWEXPENSES);
                break;

            case 3:
                listItem(list,Transcation.SHOWINCOME);
                break;
            default:
                System.out.println("No valid choice, try again\n");
        }
    }

    // This function calculate the latest balance
    public int getBalance(ArrayList<Transactions> list)  {
        int balance = 0;
        for (int x = 0; x < list.size(); x++) {
            String type = list.get(x).getType();
            int amount = list.get(x).getAmount();
            if (type.equals("Income")) {
                balance = balance + amount;
            } else {
                balance = balance - amount;
            }
        } return balance;
    }
    public String inputExpenseOrIncome(){
        boolean entry = true;
        String type =null;
        while (entry){
            System.out.println("If you want to add income write i, for expanse write e ");
            type = scan.next();
            if (type.equals("i")){
                type= "Income";
                break;
            } else if (type.equals("e")) {
                type = "Expense";
                break;
            } else {
                System.out.println("No valid choice, try again\n");
            }
        } return type;
    }
    public int inputMonth(){
        boolean entry = true;
        int month = 0;
        while (entry){
            System.out.println("Enter the month (1-12) ");
            month = scan.nextInt();
            if (month > 0 && month < 13){
                return month;
            } else {
                System.out.println("No valid choice, try again\n");
            }
        }
        return month;

    }
    public void listItem(ArrayList<Transactions> list, Transcation option)
    {
        for (int i = 0; i < list.size(); i++) {
            int serialNumber = i + 1;
            String head = list.get(i).getTittle();
            int month = list.get(i).getMonth();
            int amount = list.get(i).getAmount();
            String type = list.get(i).getType();
            if( (option == Transcation.SHOWALLTRANSCATIONS) || ((option == Transcation.SHOWINCOME) && (type.equals("Income"))) ||
                    ((option == Transcation.SHOWEXPENSES) && (type.equals("Expense"))))
            {
                System.out.println("S.No: " + serialNumber + " Month: " + month + " Amount: " + amount + "  " + head + " -" + type);
            }
        }

    }
     public boolean addOrRemove(ArrayList<Transactions> list, Operation action, int choice){ // this function add, remove and edit the transaction
        boolean success = false;
        try {
            if (action == Operation.REMOVE) {
                list.remove(choice - 1);
                return true;
            }
            String type = inputExpenseOrIncome();
            int month = inputMonth();
            System.out.println(" Enter the amount ");
            int amount = scan.nextInt();
            System.out.println("Write description of transaction ");
            String tittle = scan.next();
            tittle += scan.nextLine();
            if (action == Operation.ADD) {
                list.add(new Transactions(tittle, month, amount, type));
                success = true;
            } else if (action == Operation.EDIT) {
                list.set(choice - 1, new Transactions(tittle, month, amount, type));
                success = true;
            } else {
                System.out.println("No valid Operation, try again\n");
            }
        }
        catch (Exception e){
            System.out.println("Invalid input. Please try again");
        }
     return success;
     }

}


