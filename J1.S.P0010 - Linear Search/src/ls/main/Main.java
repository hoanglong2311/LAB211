package ls.main;

import ls.utils.ArrayManagement;
import java.util.Scanner;
import ls.utils.LinearSearch;

/**
 *
 * @author lamhnt
 */
public class Main {

    public static void main(String[] args) {
        // declare
        ArrayManagement am = new ArrayManagement();
        LinearSearch ls = new LinearSearch();
        Scanner sc = new Scanner(System.in);
        int arr[];
        String cont;

        do {
            // insert size of array
            int insNum = am.insertNum();
            arr = new int[insNum];

            // random numbers then insert into array
            arr = am.randNum(insNum);

            // sort array by Bubble Sort
            am.bubbleSort(arr);

            // insert Search Value
            int searchValue = am.insertSearchValue();
            int index = ls.linearSearch(arr, searchValue);
            if (index == -1) {
                System.out.println("The number is NOT exist!");
            } else {
                System.out.println("The number '" + searchValue + "' is at postion: " + index);
            }

            // continue or not options
            System.out.print("Do you want to continue (y/other)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
