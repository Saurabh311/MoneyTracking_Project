package moneytrackerapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

enum Transcation
{
    SHOWALLTRANSCATIONS, SHOWEXPENSES, SHOWINCOME;
}

public class AppBoard   {
    // Method to see cash transaction
    public void showTransactions(ArrayList<Transactions> list) throws InputMismatchException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select one option \n If you want to see all transactions press 1 \n if you want to see only expenses press 2 \n If you want see only Incomes press 3");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                listItem(list,Transcation.SHOWALLTRANSCATIONS);
                System.out.println("If you want to Sort the transaction, Please select 1 otherwise press any key");
                int select = scan.nextInt();
                if (select == 1){
                    System.out.println("Please select below option for sort : \n 1 for month wise(ascending order), \n 2 for amount wise(ascending order) \n 3 for type wise(ascending order)");
                    int selectSort = scan.nextInt();
                    if (selectSort == 1) {
                        Collections.sort(list, new SortByMonth());
                        listItem(list, Transcation.SHOWALLTRANSCATIONS);
                    } else if (selectSort == 2){
                        Collections.sort(list, new SortByAmount());
                        listItem(list, Transcation.SHOWALLTRANSCATIONS);
                    }else if (selectSort == 3) {
                        Collections.sort(list, new SortByType());
                        listItem(list, Transcation.SHOWALLTRANSCATIONS);
                    }
                }
                break;
            case 2:
                listItem(list,Transcation.SHOWEXPENSES);
                System.out.println("If you want to Sort the transaction, Please select 1 otherwise press any key");
                select = scan.nextInt();
                if (select == 1){
                    System.out.println("Please select below option for sort : \n 1 for month wise, \n 2 for amount wise");
                    int selectSort = scan.nextInt();
                    if (selectSort == 1) {
                        Collections.sort(list, new SortByMonth());
                        listItem(list, Transcation.SHOWEXPENSES);
                    } else if (selectSort == 2){
                        Collections.sort(list, new SortByAmount());
                        listItem(list, Transcation.SHOWEXPENSES);
                    }
                }
                break;
            case 3:
                listItem(list,Transcation.SHOWINCOME);
                System.out.println("If you want to Sort the transaction, Please select 1 otherwise press 2 ");
                select = scan.nextInt();
                if (select == 1){
                    System.out.println("Please select below option for sort : \n 1 for month wise, \n 2 for amount wise");
                    int selectSort = scan.nextInt();
                    if (selectSort == 1) {
                        Collections.sort(list, new SortByMonth());
                        listItem(list, Transcation.SHOWINCOME);
                    } else if (selectSort == 2){
                        Collections.sort(list, new SortByAmount());
                        listItem(list, Transcation.SHOWINCOME);
                    }
                }
                break;
            default:
                System.out.println("No valid choice, try again\n");
        }
    }

    // This function calculates the latest balance
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
        }
        return balance;
    }
    // This function handles the validation and user input for the income and expense.
    public String inputExpenseOrIncome (){
        Scanner scan = new Scanner(System.in);
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
        }
        return type;
    }
    // This function takes user input for the month and validates it.
    public int inputMonth() throws InputMismatchException{
        Scanner scan = new Scanner(System.in);
        boolean entry = true;
        int month = 0;
        while (entry) {
            System.out.println("Enter the month (1-12) ");
            month = scan.nextInt();
            if (month > 0 && month < 13) {
                return month;
                } else {
                      System.out.println("No valid choice, try again\n");
                }
            }
        return month;
    }
    // This function handles the display of the entries for the income and expense transcation.
    public void listItem(ArrayList<Transactions> list, Transcation option) {
        int serialNumber = 0;
        for (int i = 0; i < list.size(); i++) {
            String head = list.get(i).getTittle();
            int input = list.get(i).getMonth();
            String month = "";
            month = getMonths(input);
            int amount = list.get(i).getAmount();
            String type = list.get(i).getType();
            if( (option == Transcation.SHOWALLTRANSCATIONS) || ((option == Transcation.SHOWINCOME) && (type.equals("Income"))) ||
                ((option == Transcation.SHOWEXPENSES) && (type.equals("Expense")))) {
                   serialNumber +=1;
                   System.out.println("S.No: " + serialNumber + " Month: " + month + " Amount: " + amount + "  " + head + " -" + type);
                   System.out.println("*********************************************************************************");
            }
        }

    }
    // This function returns the month in string format.
    String getMonths(int input){
        String month = "";
        if (input == 1) {
            month = "January";
        } else if (input == 2) {
            month = "February";
        } else if (input == 3) {
            month = "March";
        } else if (input == 4) {
            month = "April";
        } else if (input == 5) {
            month = "May";
        } else if (input == 6) {
            month = "June";
        } else if (input == 7) {
            month = "July";
        } else if (input == 8) {
            month = "August";
        } else if (input == 9) {
            month = "September";
        } else if (input == 10) {
            month = "October";
        } else if (input == 11) {
            month = "November";
        } else if (input == 12) {
            month = "December";
        }
        return month;
    }
    // Method to add cash transaction
    public boolean addItem(ArrayList<Transactions> list) throws InputMismatchException{ //this function add the new transactions
        Scanner scan = new Scanner(System.in);
        boolean result = false;
        String type = inputExpenseOrIncome();
        int month = inputMonth();
        System.out.println(" Enter the amount ");
        int amount = scan.nextInt();
        System.out.println("Write description of transaction ");
        String tittle = scan.next();
        tittle += scan.nextLine();
        list.add(new Transactions(tittle, month, amount, type));
        result = true;
        System.out.println("Transaction added Successfully!");
        return result;
    }
    // Method to remove or edit the cash transaction
    public boolean removeOrEditItem(ArrayList<Transactions> list) throws InputMismatchException{     // this function remove and edit the transaction
        Scanner scan = new Scanner(System.in);
        boolean result = false;
        listItem(list,Transcation.SHOWALLTRANSCATIONS);
        System.out.println("Please enter S.no of item to be edit or remove");
        int choose = scan.nextInt();
        System.out.println("For delete this item press 1 or press 2 for edit ");
        int isRemove = scan.nextInt();
        switch (isRemove) {
            case 1:
                list.remove(choose - 1);
                result = true;
                System.out.println("Transaction removed Successfully!");
                break;
            case 2:
                String type = inputExpenseOrIncome();
                int month = inputMonth();
                System.out.println("Fill up new amount ");
                int amount = scan.nextInt();
                System.out.println("Write new tittle ");
                String tittle = scan.next();
                tittle += scan.nextLine();
                list.set(choose - 1, new Transactions(tittle, month, amount, type));
                result = true;
                System.out.println("Transaction edited Successfully!");
                break;
            default:
                System.out.println("No valid choice, try again\n");
        }
        return result;
    }
}


