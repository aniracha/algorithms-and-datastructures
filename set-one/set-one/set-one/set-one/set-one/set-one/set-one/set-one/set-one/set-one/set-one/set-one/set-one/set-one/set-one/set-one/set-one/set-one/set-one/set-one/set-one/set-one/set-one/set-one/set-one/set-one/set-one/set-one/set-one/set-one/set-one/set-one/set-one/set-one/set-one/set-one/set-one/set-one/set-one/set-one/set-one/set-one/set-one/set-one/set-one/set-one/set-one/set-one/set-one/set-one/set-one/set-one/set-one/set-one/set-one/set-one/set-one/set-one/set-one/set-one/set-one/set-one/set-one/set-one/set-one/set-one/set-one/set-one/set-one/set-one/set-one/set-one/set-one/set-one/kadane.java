package pack1;

public class kadane {

    public static int getLargestContSum(final int arr[]) {
        int maxTillNow = -Integer.MAX_VALUE;
        int sumTillNow = 0;
        for (int i = 0; i < arr.length; i++) {
            sumTillNow = Math.max(sumTillNow + arr[i], arr[i]);
            maxTillNow = Math.max(maxTillNow, sumTillNow);

        }
        return maxTillNow;
    }

    public static void main(final String args[]) {

        // final int arr[] = { -20, 3, 4, 5, -6, -7, -100, -100, 1 };
        final int arr[] = { 1, 2, -2, 4, 5, -6, -7, -100, -100, 1 };
        System.out.println(getLargestContSum(arr));

    }

}
