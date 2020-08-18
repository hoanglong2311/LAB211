package bc.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class InputValidation {

    // declare
    Scanner sc = new Scanner(System.in);

    // check input option menu
    public int validateMenuOption(int firstOption, int lastOption) {
        // declare
        int option;

        while (true) {
            try {
                option = Integer.parseInt(sc.nextLine().trim());
                if (option < firstOption || option > lastOption) {
                    throw new NumberFormatException();
                }
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Option must between " + firstOption + " and " + lastOption);
                System.out.print("Your choice: ");
            }
        }
    }

    // check input double for Normal Calculator
    public double validateDouble() {
        // declare
        double inputDouble;

        while (true) {
            try {
                inputDouble = Double.parseDouble(sc.nextLine().trim());
                return inputDouble;
            } catch (NumberFormatException e) {
                System.out.println("Please input Double number !!!");
                System.out.print("Enter Double number: ");
            }
        }
    }

    // check input double for BMI Calculator
    public double validatePositiveDouble() {
        // declare
        double inputDouble;

        while (true) {
            try {
                inputDouble = Double.parseDouble(sc.nextLine().trim());
                if (inputDouble <= 0) {
                    throw new NumberFormatException();
                } else {
                    return inputDouble;
                }
            } catch (NumberFormatException e) {
                System.err.println("Height & Weight must be POSITIVE !!!");
                System.out.print("Enter again: ");
            }
        }
    }

    // check & return input number after inputting an operator
    public double inputNumber() {
        // declare
        double number;

        System.out.print("Enter Number: ");
        number = validateDouble();

        return number;
    }

    // check input operators
    public String validateOperator() {
        // declare
        String operator;

        while (true) {
            operator = sc.nextLine().trim();
            if (operator.isEmpty()) {
                System.out.println("Must not be empty!");
            } else if (operator.equalsIgnoreCase("+")
                    || operator.equalsIgnoreCase("-")
                    || operator.equalsIgnoreCase("*")
                    || operator.equalsIgnoreCase("/")
                    || operator.equalsIgnoreCase("^")
                    || operator.equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
            System.out.print("Enter Operator: ");
        }
    }
}
