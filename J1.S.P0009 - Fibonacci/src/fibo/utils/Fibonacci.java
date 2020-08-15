package fibo.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Fibonacci {

    // declare
    Scanner sc = new Scanner(System.in);

    // check number
    public int checkInsNum() {
        while (true) {
            try {
                int checkedNum = Integer.parseInt(sc.nextLine().trim());
                if (checkedNum < 0) {
                    throw new NumberFormatException();
                } else {
                    return checkedNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a POSITIVE NUMBER again!");
                System.out.print("Enter number of sequence of Fibonacci: ");
            }
        }
    }

    // insert integer number to determine sequence of Fibonacci
    public int insertNum() {
        int insNum = 0;

        System.out.print("Enter number of sequence of Fibonacci: ");
        insNum = checkInsNum();

        return insNum;
    }

    // fibonacci
    public long fibonacci(int insNum) {
        if ((insNum == 0 || insNum == 1)) {
            return insNum;
        } else {
            return fibonacci(insNum - 1) + fibonacci(insNum - 2);
        }
    }

    // display
    public void display(int insNum) {
        System.out.println("The " + insNum + " sequence of Fibonacci:");
        for (int i = 0; i < insNum; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
