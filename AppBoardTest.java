package moneytrackerapp;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.rules.ExternalResource;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class AppBoardTest extends TestCase {

    public void testGetBalance() {
        AppBoard app = new AppBoard();
        ArrayList<Transactions> list = new ArrayList<Transactions>();
        list.add(new Transactions("ICA", 2, 2000, "Expense"));
        list.add(new Transactions("Coop", 2, 3000, "Expense"));
        list.add(new Transactions("Travel", 2, 4000, "Expense"));
        list.add(new Transactions("Salary", 1, 50000, "Income"));
        int result = app.getBalance(list);
        int expected = 41000;
        assertEquals(expected, result);
    }

    public void testInputExpenseOrIncome() {
        AppBoard app = new AppBoard();
        String input = "i";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String typeI = app.inputExpenseOrIncome();
        String expectedType = "Income";
        assertEquals(expectedType, typeI);

        //2nd Scenario
        String input1 = "e";
        InputStream  ins = new ByteArrayInputStream(input.getBytes());
        System.setIn(ins);
        String typeE = app.inputExpenseOrIncome();
        String expectedType1 = "Expense";
        assertEquals(expectedType, typeE);
    }
}