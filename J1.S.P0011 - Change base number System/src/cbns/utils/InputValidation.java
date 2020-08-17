package cbns.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class InputValidation {

    // declare
    Scanner sc = new Scanner(System.in);
    String BINARY_VALIDATION = "[0-1]*";
    String DECIMAL_VALIDATION = "[0-9]*";
    String HEXADECIMAL_VALIDATION = "[0-9A-F]*";

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

    // check Binary Number
    public String validateInputBinary() {
        // declare
        String binaryNumber;

        // binary validation
        System.out.print("Enter Binary number: ");
        while (true) {
            binaryNumber = sc.nextLine().trim();
            if (binaryNumber.matches(BINARY_VALIDATION)) {
                return binaryNumber;
            } else {
                System.out.println("Binary Number includes 0 or 1 !!!");
                System.out.print("Enter Binary number: ");
            }
        }
    }

    // check Decimal Number
    public String validateInputDecimal() {
        // declare
        String decimalNumber;

        // decimal validation
        System.out.print("Enter Decimal number: ");
        while (true) {
            decimalNumber = sc.nextLine().trim();
            if (decimalNumber.matches(DECIMAL_VALIDATION)) {
                return decimalNumber;
            } else {
                System.out.println("Decimal Number includes 0 to 9 !!!");
                System.out.print("Enter Decimal number: ");
            }
        }
    }

    // check Hexadecimal Number
    public String validateInputHexadecimal() {
        // declare
        String hexadecimalNumber;

        // decimal validation
        System.out.print("Enter Hexadecimal number: ");
        while (true) {
            hexadecimalNumber = sc.nextLine().trim();
            if (hexadecimalNumber.matches(HEXADECIMAL_VALIDATION)) {
                return hexadecimalNumber;
            } else {
                System.out.println("Hexadecimal Number includes 0 to 9, A to F !!!");
                System.out.print("Enter Hexadecimal number: ");
            }
        }
    }
}
