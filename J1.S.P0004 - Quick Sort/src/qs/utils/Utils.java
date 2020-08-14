package qs.utils;

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

    // quick sort
    public int partrition(int arr[], int start, int end) {
        // declare
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;

        return i + 1;
    }

    public void quickSort(int arr[], int start, int end) {

        if (start < end) {
            int pIndex = partrition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }
}
