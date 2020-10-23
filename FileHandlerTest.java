package moneytrackerapp;
import junit.framework.TestCase;

import java.util.ArrayList;

public class FileHandlerTest extends TestCase {

    public void testWriteReadFile() {
        FileHandler fh = new FileHandler();
        ArrayList<Transactions> list = new ArrayList<Transactions>();
        ArrayList<Transactions> readList;
        list.add(new Transactions("ICA", 2, 2000, "Expense"));
        list.add(new Transactions("Coop", 2, 3000, "Expense"));
        list.add(new Transactions("Travel", 2, 4000, "Expense"));
        list.add(new Transactions("Salary", 1, 50000, "Income"));
        fh.writeFile(list);
        readList = fh.readFile();
        int expectedEntriesInFile = 4;
        assertEquals(expectedEntriesInFile, readList.size());
    }
}