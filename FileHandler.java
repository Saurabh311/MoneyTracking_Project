package Shapes;

import java.io.*;
import java.util.ArrayList;

public class FileHandler{

    public ArrayList<Transactions> readFile(){
        ArrayList<Transactions> list = new ArrayList<>();
        try {
        FileInputStream fis = new FileInputStream("cash");
        ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ArrayList<Transactions>) ois.readObject();
            ois.close();
        } catch (EOFException e) {
            System.out.println("The file is empty");
        } catch (IOException e) {
            System.out.println("the file is not fount");
        } catch (ClassNotFoundException e) {
            System.out.println("the file contains wireed things");
        }
        return list;
    }
    public void writeFile(ArrayList<Transactions> list)
    {
        try
        {
            FileOutputStream fis = new FileOutputStream("cash");
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(list);

            ois.close();
        } catch (EOFException e) {
            System.out.println("The file is empty");
        } catch (IOException e) {
            System.out.println("the file is not fount");
        }
    }

}
