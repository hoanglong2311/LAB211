package ms.main;

import java.util.Arrays;
import ms.utils.Utils;
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
            // sort array by Merge Sort
            utils.mergeSort(arr, 0, arr.length - 1);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
            // continue or not
            System.out.print("Do you want to continue (y/other)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
