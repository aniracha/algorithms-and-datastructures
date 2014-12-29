package pack1;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

    static void findLongestSubsequence(final int arr[]) {
        final int max[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                }
            }
        }
        int m = max[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max[i] > m) {
                m = max[i];
                index = i;
            }
        }

        final ArrayList<Integer> newList = new ArrayList<Integer>();

        newList.add(arr[index]);
        int current = index;
        int previous = index - 1;
        int count = 0;
        while (current > 1) {
            if (max[previous] == max[current] - 1) {
                newList.add(0, arr[previous]);
                current = previous;
                previous = current - 1;
                count++;
                // System.out.println("current : " + current);
                // System.out.println("previous : " + previous);
                if (count == m) {
                    break;
                }
            } else {
                previous--;
            }
        }
        System.out.println("the LIS : " + m);
        for (final int i : newList) {
            System.out.print(i + " ");
        }
    }

    public static void main(final String args[]) {
        final int arr[] = { 4, 1, 2, 3, 8, 9, 10, -1, -2, 100, 67, 90, 101, 120, 3, 140, 4, 150, 6, 170, 23 };
        findLongestSubsequence(arr);
    }
}
