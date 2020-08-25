package fs.menus;

import fs.utils.InputValidation;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Menu {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();

    // main menu
    public int mainMenu() {
        System.out.println("--- Fruit Shop ---");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Order");
        System.out.println("3. Shopping");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        int choice = iv.validateMenuOption(1, 4);
        return choice;
    }

}
