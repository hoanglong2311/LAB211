package bs.utils;

/**
 *
 * @author lamhnt
 */
public class BinarySearch {

    public int binarySearch(int arr[], int left, int right, int target) {
        if (right >= 1) {
            int middle = left + (right - 1) / 2;

            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] > target) {
                return binarySearch(arr, left, middle - 1, target);
            } else {
                return binarySearch(arr, middle + 1, right, target);
            }

        }

        return -1;
    }
}
