package pack1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AllPermutations {

    static List<String> getPermutations(final String input) {

        final List<String> listOfPermutations = new ArrayList<String>();
        if (input.length() == 1) {
            listOfPermutations.add(input);
            return listOfPermutations;
        }
        final char first = input.charAt(0);
        final List<String> resducedPermutation = getPermutations(input.substring(1));
        for (final String s : resducedPermutation) {
            for (int i = 0; i <= s.length(); i++) {
                final String newEntry = s.substring(0, i) + first + s.substring(i);
                listOfPermutations.add(newEntry);
            }
        }

        return listOfPermutations;
    }

    public static void main(final String args[]) {

        final Stack<Integer> stack = new Stack<Integer>();
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        final int arr[] = { 1, 2, 4, 5, 6, 23, 5, 6, 7, 8, 9 };
        final int index = (int) (Math.random() * (arr.length - 0)) + 0;
        System.out.println(index);

        for (final String s : getPermutations("ani")) {
            System.out.println(s);
        }

    }
}
