//author:Calvin Power

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The type Test.
 */
public class test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */

     public static void main(String[] args) throws IOException {

                CLI cli = new CLI();
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter run");
                String a = scan.nextLine();

                if(a.equals("run") || a.equals("Run")) {
                    cli.run();
                }
            }
        }




