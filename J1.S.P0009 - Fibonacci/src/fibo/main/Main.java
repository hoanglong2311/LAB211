package fibo.main;

import fibo.utils.Fibonacci;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        //declare
        Scanner sc = new Scanner(System.in);
        Fibonacci fibo = new Fibonacci();
        int insNum;
        String cont;

        do {
            // insert number of sequence
            insNum = fibo.insertNum();

            // display fibonacci sequence
            fibo.display(insNum);

            // continue or not
            System.out.println();
            System.out.print("Do you want to continue (y/other)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
