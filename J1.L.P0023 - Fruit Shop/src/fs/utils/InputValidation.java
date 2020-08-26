package fs.utils;

import fs.entities.Fruit;
import fs.entities.Order;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class InputValidation {

    // delcare
    Scanner sc = new Scanner(System.in);
    private static final String FRUITID_VALID = "^[FR,fr]{2}[0-9]{3}$";

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
                System.err.println("Option must between " + firstOption + " and " + lastOption);
                System.out.print("Your choice: ");
            }
        }
    }

    // check empty string
    public String checkEmptyString() {
        // declare
        String content;

        while (true) {
            content = sc.nextLine().trim();
            if (content.isEmpty()) {
                System.err.println("Must not be empty");
                System.out.print("Enter again: ");
            } else {
                return content;
            }
        }
    }

    // check Fruit ID
    public String checkFruitID() {
        while (true) {
            String fruitID = checkEmptyString();
            if (!fruitID.matches(FRUITID_VALID)) {
                System.err.println("Fruit ID format: FR001");
                System.out.print("Enter Fruit ID: ");
            } else {
                return fruitID.toUpperCase();
            }
        }
    }

    // check Fruit Name
    public String checkFruitName() {
        while (true) {
            String fruitName = checkEmptyString();
            if (fruitName.length() > 15) {
                System.err.println("Name is too long");
                System.out.print("Enter Fruit Name: ");
            } else if (!fruitName.matches("[A-Za-z ]*")) {
                System.err.println("Name contains only alphabet");
                System.out.print("Enter Fruit Name: ");
            } else if (fruitName.matches("^[A-Za-z ]*(.)\\1\\1$")) {
                System.err.println("A character must not repeat 3 times");
                System.out.print("Enter Fruit Name: ");
            } else {
                return fruitName.toUpperCase();
            }
        }
    }

    // check Fruit Origin
    public String checkFruitOrigin() {
        while (true) {
            String origin = checkEmptyString();
            if (origin.length() > 15) {
                System.err.println("Origin is too long");
                System.out.print("Enter Fruit Origin: ");
            } else if (!origin.matches("[A-Za-z ]*")) {
                System.err.println("Origin contains only alphabet");
                System.out.print("Enter Fruit Origin: ");
            } else if (origin.matches("^[A-Za-z ]*(.)\\1\\1$")) {
                System.err.println("A character must not repeat 3 times");
                System.out.print("Enter Fruit Origin: ");
            } else {
                return origin.toUpperCase();
            }
        }
    }

    // check Customer Name
    public String checkCustomerName() {
        while (true) {
            String cusName = checkEmptyString();
            if (cusName.length() > 15) {
                System.err.println("Name is too long");
                System.out.print("Enter Your Name: ");
            } else if (!cusName.matches("[A-Za-z ]*")) {
                System.err.println("Name contains only alphabet");
                System.out.print("Enter Your Name: ");
            } else if (cusName.matches("^[A-Za-z ]*(.)\\1\\1$")) {
                System.err.println("A character must not repeat 3 times");
                System.out.print("Enter Your Name: ");
            } else {
                return cusName.toUpperCase();
            }
        }
    }

    // check input Integer
    public int checkInputInteger() {
        while (true) {
            try {
                int intNumber = Integer.parseInt(sc.nextLine().trim());
                if (intNumber <= 0) {
                    throw new NumberFormatException();
                } else {
                    return intNumber;
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be Integer and larger than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    // check input Double
    public double checkInputDouble() {
        while (true) {
            try {
                double intDouble = Double.parseDouble(sc.nextLine().trim());
                if (intDouble <= 0) {
                    throw new NumberFormatException();
                } else {
                    return intDouble;
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be Double and larger than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    // check input Continue Option (Y/N)
    public boolean checkContinue() {
        System.out.print("Do you want to continue (y/n)? ");
        while (true) {
            // check empty input
            String cont = checkEmptyString();
            // continue
            if (cont.equalsIgnoreCase("y")) {
                return true;
            }
            // stop
            if (cont.equalsIgnoreCase("n")) {
                return false;
            }
            // else
            System.err.println("Y/y to continue or N/n to stop");
            System.out.print("Do you want to continue (y/n)? ");
        }
    }

    // check Fruit ID existence
    public boolean checkIDExistence(ArrayList<Fruit> fruitList, String fruitID) {
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitID().equalsIgnoreCase(fruitID)) {
                // existed
                return true;
            }
        }
        // non-existed
        return false;
    }

    // check whether item existed or not
    public boolean checkItemExistence(ArrayList<Order> orderList, String fruitID) {
        for (Order order : orderList) {
            if (order.getFruitID().equalsIgnoreCase(fruitID)) {
                // existed
                return true;
            }
        }
        // non-existed
        return false;
    }

    // check available item
    public int checkAvailableItem(int quantityLeft) {
        while (true) {
            try {
                int quantity = Integer.parseInt(sc.nextLine().trim());
                if (quantity > quantityLeft) {
                    throw new NumberFormatException();
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                System.err.println("Available Item: " + quantityLeft);
                System.out.print("Enter Fruit Quantity: ");
            }
        }
    }
}
