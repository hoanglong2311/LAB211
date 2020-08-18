package bc.main;

import bc.utils.BMICalculator;
import bc.utils.Menu;
import bc.utils.NormalCalculator;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Menu mn = new Menu();
        NormalCalculator nc = new NormalCalculator();
        BMICalculator bc = new BMICalculator();
        int option;

        // main menu
        while (true) {
            option = mn.mainMenu();

            switch (option) {
                case 1:
                    nc.calculateNormal();
                    break;
                case 2:
                    bc.calculateBMI();
                    break;
                case 3:
                    return;
            }
        }
    }
}
