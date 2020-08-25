package fs.mains;

import fs.entities.Fruit;
import fs.entities.Order;
import fs.managements.FruitManagement;
import fs.menus.Menu;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {

        // declare
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> orderTable = new Hashtable<>();
        Menu mn = new Menu();
        FruitManagement fm = new FruitManagement();

        // main menu
        while (true) {
            int choice = mn.mainMenu();
            switch (choice) {
                case 1:
                    // create Fruit
                    fm.createFruit(fruitList);
                    break;
                case 2:
                    // view Order
                    fm.viewOrder(orderTable);
                    break;
                case 3:
                    // shopping
                    fm.shopping(fruitList, orderTable);
                    break;
                case 4:
                    return;
            }
        }

    }
}
