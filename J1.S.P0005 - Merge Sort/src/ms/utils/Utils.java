package ms.utils;

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
    public void merge(int arr[], int left, int middle, int right) {
        // size of 2 subArrays
        int sub1 = middle - left + 1;
        int sub2 = right - middle;

        // temporary Arrays
        int arrLeft[] = new int[sub1];
        int arrRight[] = new int[sub2];

        // copy data to temporary Arrays
        for (int i = 0; i < sub1; i++) {
            arrLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sub2; j++) {
            arrRight[j] = arr[middle + 1 + j];
        }

        // initial indexes of sub1 and sub2
        int i = 0, j = 0;
        int key = left;

        while (i < sub1 && j < sub2) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[key] = arrLeft[i];
                i++;
            } else {
                arr[key] = arrRight[j];
                j++;
            }
            key++;
        }

        while (i < sub1) {
            arr[key] = arrLeft[i];
            i++;
            key++;
        }

        while (j < sub2) {
            arr[key] = arrRight[j];
            j++;
            key++;
        }
    }

    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }
}
