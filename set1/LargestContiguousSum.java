package pack1;

public class LargestContiguousSum {

    public static int getSum(final int arr[]) {

        int maxTillNow = -Integer.MAX_VALUE;
        // System.out.println(maxTillNow);
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxTillNow && currentSum > arr[i]) {
                maxTillNow = currentSum;
            } else {
                currentSum = arr[i];
                if (maxTillNow < arr[i]) {
                    maxTillNow = arr[i];
                }
            }
            System.out.println(maxTillNow);

        }
        return maxTillNow;
    }

    public static void main(final String args[]) {
        final int arr[] = { -20, 3, 4, 5, -6, -7, -100, -100, 1 };
        System.out.println("the sum is = " + getSum(arr));
    }

}
