package cbns.main;

import cbns.utils.Conversion;
import cbns.utils.InputValidation;
import cbns.utils.Menu;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Menu mn = new Menu();
        InputValidation iv = new InputValidation();
        int option;

        // menu
        while (true) {
            option = mn.displayMainMenu();

            switch (option) {
                case 1:
                    System.out.println("--- BINARY Conversion ---");
                    String binaryNumber = iv.validateInputBinary();
                    mn.convertFromBinary(binaryNumber);
                    break;
                case 2:
                    System.out.println("--- DECIMAL Conversion ---");
                    String decimalNumber = iv.validateInputDecimal();
                    mn.convertFromDecimal(decimalNumber);
                    break;
                case 3:
                    System.out.println("--- HEXADECIMAL Conversion ---");
                    String hexadecimalNumber = iv.validateInputHexadecimal();
                    mn.convertFromHexadecimal(hexadecimalNumber);
                    break;
                case 4:
                    return;
            }
        }
    }
}
