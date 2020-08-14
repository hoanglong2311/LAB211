package is.main;

import is.utils.Utils;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Utils utils = new Utils();
        int arr[];
        String cont;
        Scanner sc = new Scanner(System.in);

        do {
            // insert size of array
            int insNum = utils.insertNum();
            arr = new int[insNum];
            // random number then insert into array
            arr = utils.randNum(insNum);
            // sort array by Insertion Sort
            utils.insertionSort(arr);

            // continue or not
            System.out.print("Do you want to continue (y/n)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
