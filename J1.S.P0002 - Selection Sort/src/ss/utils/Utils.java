package ss.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lamhnt
 */
public class Utils {

    // declare
    Scanner sc = new Scanner(System.in);
    int arr[];

    // check number
    public int checkInsNum() {
        while (true) {
            try {
                int checkedNum = Integer.parseInt(sc.nextLine().trim());
                if (checkedNum < 0) {
                    throw new NumberFormatException();
                } else {
                    return checkedNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a POSITIVE NUMBER again!");
                System.out.print("Enter number of Array: ");
            }
        }
    }

    // insert number
    public int insertNum() {
        int insNum = 0;

        System.out.print("Enter number of Array: ");
        insNum = checkInsNum();

        return insNum;
    }

    // random number into array
    public int[] randNum(int insNum) {
        arr = new int[insNum];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        return arr;
    }

    // selection sort
    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
