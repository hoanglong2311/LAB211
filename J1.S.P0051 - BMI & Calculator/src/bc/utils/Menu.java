package bc.utils;

import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Menu {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();

    // Main Menu
    public int mainMenu() {
        // declare
        int option;

        System.out.println("--- Calculator Program ---");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
        option = iv.validateMenuOption(1, 3);

        return option;
    }
}
