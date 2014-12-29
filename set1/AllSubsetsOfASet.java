package pack1;

import java.util.ArrayList;

public class AllSubsetsOfASet {

    static ArrayList<ArrayList<Integer>> getSubsets(final ArrayList<Integer> input) {
        final ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
        final ArrayList<Integer> intermediateResult = new ArrayList<Integer>();
        if (input.isEmpty()) {
            System.out.println("empty");
            finalResult.add(intermediateResult);
            return finalResult;
        }
        final int first = input.get(0);
        input.remove(0);
        final ArrayList<ArrayList<Integer>> inter = getSubsets(input);
        final ArrayList<ArrayList<Integer>> clone = getSubsets(input);
        clone.addAll(inter);

        // System.out.println(clone.toString());

        if (clone.isEmpty()) {
            System.out.println("holla");
            // final ArrayList<Integer> newArrayList = new ArrayList<Integer>();
            // newArrayList.add(first);
            // clone.add(newArrayList);
        }
        for (final ArrayList<Integer> ii : clone) {
            ii.add(0, first);
        }
        System.out.println("inter " + inter.toString());
        System.out.println("clone " + clone.toString());
        finalResult.addAll(inter);
        finalResult.addAll(clone);

        return finalResult;
    }

    public static void main(final String args[]) {

        final ArrayList<Integer> inter = new ArrayList<Integer>();
        inter.add(1);
        inter.add(2);
        inter.add(3);
        for (final ArrayList<Integer> i : getSubsets(inter)) {
            for (final int i1 : i) {
                System.out.print(i1);
            }
            System.out.println();
        }

    }
}
