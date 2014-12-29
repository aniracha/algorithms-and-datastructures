package pack1;

public class SubsetSum {

    public static boolean isSubsetSum(final int arr[], final int sum, final int numOfElements) {
        if (sum == 0) {
            return true;
        } else if (sum != 0 && numOfElements == 0) {
            return false;
        } else {
            if (arr[numOfElements - 1] > sum) {
                isSubsetSum(arr, sum, numOfElements - 1);
            }

            return isSubsetSum(arr, sum - arr[numOfElements - 1], numOfElements - 1)
                    || isSubsetSum(arr, sum, numOfElements - 1);
        }

    }

    public static void main(final String args[]) {
        final int arr[] = { 1, 2, 3, 45, -1, -2, 100 };
        if (isSubsetSum(arr, 48, arr.length)) {
            System.out.println("it is a subset");
        } else {
            System.out.println("not a subset");
        }
    }

}
