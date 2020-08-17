package cbns.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Menu {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();
    Conversion cvs = new Conversion();

    // Main Menu
    public int displayMainMenu() {
        // declare
        int choice;

        // menu
        System.out.println("--- CHANGE BASE NUMBER SYSTEM ---");
        System.out.println("1. Convert from Binary");
        System.out.println("2. Convert from Decimal");
        System.out.println("3. Convert from Hexadecimal");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        choice = iv.validateMenuOption(1, 4);

        return choice;
    }

    // Conversion Menu
    public int chooseConversion(String base, String conversion_1, String conversion_2) {
        // declare
        int option;

        // Conversion Menu
        System.out.println("1. Convert from " + base.toUpperCase() + " to " + conversion_1.toUpperCase());
        System.out.println("2. Convert from " + base.toUpperCase() + " to " + conversion_2.toUpperCase());
        System.out.print("Your choice: ");
        option = iv.validateMenuOption(1, 2);

        return option;
    }

    // Binary Menu
    public void convertFromBinary(String binaryNumber) {
        int option = chooseConversion("Binary", "Decimal", "Hexadecimal");
        switch (option) {
            case 1:
                System.out.println("Decimal Number: " + cvs.convertBinaryToDecimal(binaryNumber));
                break;
            case 2:
                System.out.println("Hexadecimal Number: " + cvs.convertBinaryToHexadecimal(binaryNumber));
                break;
        }
    }

    // Decimal Menu
    public void convertFromDecimal(String decimalNumber) {
        int option = chooseConversion("Decimal", "Binary", "Hexadecimal");
        switch (option) {
            case 1:
                System.out.println("Binary Number: " + cvs.convertDecimalToBinary(decimalNumber));
                break;
            case 2:
                System.out.println("Hexadecimal Number: " + cvs.convertDecimalToHexadecimal(decimalNumber));
                break;
        }
    }

    // Hexadecimal Menu
    public void convertFromHexadecimal(String hexadecimalNumber) {
        int option = chooseConversion("Hexadecimal", "Binary", "Decimal");
        switch (option) {
            case 1:
                System.out.println("Binary Number: " + cvs.convertHexadecimalToBinary(hexadecimalNumber));
                break;
            case 2:
                System.out.println("Decimal Number: " + cvs.convertHexadecimalToDecimal(hexadecimalNumber));
                break;
        }
    }
}
