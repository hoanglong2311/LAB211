package bc.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class NormalCalculator {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();

    public void calculateNormal() {
        // declare
        double memory;
        String operator;

        System.out.print("Enter Number: ");
        memory = iv.validateDouble();

        while (true) {
            System.out.print("Enter Operator: ");
            operator = iv.validateOperator();

            // plus
            if (operator.equalsIgnoreCase("+")) {
                memory += iv.inputNumber();
                System.out.println("Memory: " + memory);
            }

            // minus
            if (operator.equalsIgnoreCase("-")) {
                memory -= iv.inputNumber();
                System.out.println("Memory: " + memory);
            }

            // multiply
            if (operator.equalsIgnoreCase("*")) {
                memory *= iv.inputNumber();
                System.out.println("Memory: " + memory);
            }

            // division
            if (operator.equalsIgnoreCase("/")) {
                if (iv.inputNumber() == 0) {
                    System.out.println("Can't divide by 0");
                    return;
                } else {
                    System.out.println("Memory: " + memory);
                }
            }

            // pow
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, iv.inputNumber());
                System.out.println("Memory: " + memory);
            }

            // result
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Memory: " + memory);
                return;
            }
        }
    }
}
