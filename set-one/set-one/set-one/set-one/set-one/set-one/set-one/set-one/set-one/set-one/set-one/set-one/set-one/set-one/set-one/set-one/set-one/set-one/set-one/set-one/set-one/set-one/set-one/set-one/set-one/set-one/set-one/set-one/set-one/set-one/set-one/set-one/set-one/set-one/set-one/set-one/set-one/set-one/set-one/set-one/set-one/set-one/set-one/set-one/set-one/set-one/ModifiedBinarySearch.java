package pack1;

public class ModifiedBinarySearch {

    public static void main(final String args[]) {
        final int arr[] = { 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(findIndexOfPivot(arr, 0, arr.length - 1));
        System.out.println(doModifiedBinarySearch(arr, 0, arr.length - 1, 3));
    }

    public static int doModifiedBinarySearch(final int arr[], final int left, final int right, final int number) {
        final int index = findIndexOfPivot(arr, left, right);
        if (number == arr[index]) {
            return index;
        }

        if (number > arr[left]) {
            return doBinarySearch(arr, left, index - 1, number);
        } else {
            return doBinarySearch(arr, index + 1, right, number);
        }

    }

    public static int doBinarySearch(final int arr[], final int left, final int right, final int number) {
        if (left > right) {
            return -1;
        }

        final int mid = (left + right) >> 1;
        if (arr[mid] == number) {
            return mid;
        } else if (number < arr[mid]) {
            return doBinarySearch(arr, left, mid - 1, number);
        } else {
            return doBinarySearch(arr, mid + 1, right, number);
        }

    }

    public static int findIndexOfPivot(final int arr[], final int left, final int right) {
        if (left > right) {
            return -1;
        }

        final int mid = (left + right) / 2;
        if (mid + 1 <= right && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid - 1 >= left && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[left] >= arr[mid]) {
            System.out.println("inside right");
            return findIndexOfPivot(arr, left, mid - 1);
        } else {
            System.out.println("inside left");
            return findIndexOfPivot(arr, mid + 1, right);
        }

    }
}
