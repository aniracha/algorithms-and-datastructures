package pack1;

import java.util.Random;

public class SumFinder {

    public static void main(final String args[]) {

        final int arr[] = { 1, 3, 5, 7, 9, 11, 13, 15 };
        while (true) {
            final int first = (arr[(new Random()).nextInt(arr.length)]);
            final int second = (arr[(new Random()).nextInt(arr.length)]);
            final int third = (arr[(new Random()).nextInt(arr.length)]);
            final int fourth = (arr[(new Random()).nextInt(arr.length)]);
            final int fifth = (arr[(new Random()).nextInt(arr.length)]);
            if (first + second + third + fourth + fifth == 30) {
                System.out.println(first);
                System.out.println(second);
                System.out.println(third);
                System.out.println(fourth);
                System.out.println(fifth);
                break;
            }
        }
    }
}
