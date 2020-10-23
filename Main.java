package moneytrackerapp;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        try {
            RunApp startRun = new RunApp();
            startRun.startApp();
        }
         catch (IOException e){
            System.out.println("IO Error  :" + e);
            System.out.println("Couldn't read the file. program restarted, try again!\n");
            main(new String[0]);
        }
        catch (InputMismatchException e){
            System.out.println("Input Error  :" + e);
            System.out.println("Please provide only numbers (no text, only real numbers). Program restarted, try again!\n");
            main(new String[0]);
        }
        catch(Exception e){
            System.out.println("Exception thrown  :" + e);
            main(new String[0]);
        }
    }
}
