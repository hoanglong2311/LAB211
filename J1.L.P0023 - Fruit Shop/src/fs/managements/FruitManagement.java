package fs.managements;

import fs.entities.Fruit;
import fs.entities.Order;
import fs.utils.InputValidation;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class FruitManagement {

    // declare
    Scanner sc = new Scanner(System.in);
    InputValidation iv = new InputValidation();

    // create Fruit
    public void createFruit(ArrayList<Fruit> fruitList) {
        while (true) {
            // check whether ID existed or not
            String fruitID;
            while (true) {
                System.out.print("Enter Fruit ID: ");
                fruitID = iv.checkFruitID();
                if (iv.checkIDExistence(fruitList, fruitID)) {
                    System.err.println("ID existed");
                } else {
                    break;
                }
            }

            // ID doesn't exist
            System.out.print("Enter Fruit Name: ");
            String fruitName = iv.checkFruitName();
            System.out.print("Enter Fruit Price: ");
            double price = iv.checkInputDouble();
            System.out.print("Enter Fruit Quantity: ");
            int quantity = iv.checkInputInteger();
            System.out.print("Enter Fruit Origin: ");
            String origin = iv.checkFruitOrigin();

            // add fruit to Fruit List
            fruitList.add(new Fruit(fruitID, fruitName, price, quantity, origin));

            // check whether user want to continue or not
            if (!iv.checkContinue()) {
                return;
            }
        }
    }

    // display Order List
    public void displayOrderList(ArrayList<Order> orderList) {
        // declare
        double total = 0;

        // column title
        System.out.printf("%15s|%10s|%7s|%7s\n", "Product", "Quantity", "Price", "Amount");
        // list the orders
        for (Order order : orderList) {
            System.out.printf("%15s|%10s|%6.0f$|%6.0f$\n",
                    order.getFruitName(),
                    order.getQuantity(),
                    order.getPrice(),
                    order.getPrice() * order.getQuantity());

            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    // view Order
    // key: customer name
    // value: ArrayList<Order>
    public void viewOrder(Hashtable<String, ArrayList<Order>> orderTable) {
        // declare
        boolean flagFound = false;

        for (String customerName : orderTable.keySet()) {
            System.out.println("Customer: " + customerName);
            ArrayList<Order> orderList = orderTable.get(customerName);
            displayOrderList(orderList);
            flagFound = true;
        }

        if (flagFound == false) {
            System.err.println("Empty Order");
        }
    }

    // display Fruit List
    public void displayFruitList(ArrayList<Fruit> fruitList) {
        // declare
        int count = 1;

        // column title
        System.out.printf("%5s|%15s|%15s|%7s\n", "Item", "Fruit Name", "Origin", "Price");
        // list all the fruits
        for (Fruit fruit : fruitList) {
            // check whether item is available or not
            if (fruit.getQuantity() != 0) {
                System.out.printf("%5s|%15s|%15s|%7.0f$\n",
                        count++,
                        fruit.getFruitName(),
                        fruit.getOrigin(),
                        fruit.getPrice());
            }
        }
    }

    // choose Fruit by Item Number
    public Fruit getFruitByItemNo(ArrayList<Fruit> fruitList, int itemNo) {
        int count = 1;
        for (Fruit fruit : fruitList) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (count - 1 == itemNo) {
                return fruit;
            }
        }
        return null;
    }

    // if order is existed
    // then update the order
    // instead of create a new one
    public void updateOrder(ArrayList<Order> orderList, String fruitID, int quantity) {
        for (Order order : orderList) {
            if (order.getFruitID().equalsIgnoreCase(fruitID)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    // shopping
    public void shopping(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Order>> orderTable) {
        // check Fruit List empty or not
        if (fruitList.isEmpty()) {
            System.err.println("Empty Store");
            return;
        }
        // start buying fruit until user choose "N"(No) continue option
        ArrayList<Order> orderList = new ArrayList<>();
        while (true) {
            displayFruitList(fruitList);
            System.out.print("Enter Item Number: ");
            int itemNo = iv.validateMenuOption(1, fruitList.size());
            Fruit chosenFruit = getFruitByItemNo(fruitList, itemNo);
            System.out.print("Enter Fruit Quantity: ");
            int quantity = iv.checkAvailableItem(chosenFruit.getQuantity());
            chosenFruit.setQuantity(chosenFruit.getQuantity() - quantity);

            if (iv.checkItemExistence(orderList, chosenFruit.getFruitID())) {
                updateOrder(orderList, chosenFruit.getFruitID(), quantity);
            } else {
                orderList.add(new Order(chosenFruit.getFruitID(),
                        chosenFruit.getFruitName(),
                        chosenFruit.getPrice(),
                        chosenFruit.getQuantity()));
            }
            // customer choose continue or not
            if (!iv.checkContinue()) {
                // display final order
                displayOrderList(orderList);
                // require customer name to add to order table
                System.out.print("Enter Your Name: ");
                String cusName = iv.checkCustomerName();
                orderTable.put(cusName, orderList);
                System.out.println("---> Shopping Successful");
                return;
            }
        }
    }
}
