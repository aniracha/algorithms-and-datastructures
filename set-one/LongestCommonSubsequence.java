package pack1;

public class LongestCommonSubsequence {

    public static int getLCS(final char first[], final int lengthOfFirst, final char second[], final int lengthOfSecond) {
        if (lengthOfFirst == 0 && lengthOfSecond == 0) {
            return 0;
        } else if (lengthOfFirst != 0 && lengthOfSecond == 0) {
            return 0;
        } else if (lengthOfFirst == 0 && lengthOfSecond != 0) {
            return 0;
        } else {
            if (first[lengthOfFirst - 1] != second[lengthOfSecond - 1]) {
                return Math.max(getLCS(first, lengthOfFirst, second, lengthOfSecond - 1),
                        getLCS(first, lengthOfFirst - 1, second, lengthOfSecond));
            } else {
                return (1 + getLCS(first, lengthOfFirst - 1, second, lengthOfSecond - 1));
            }
        }
    }

    public static void main(final String args[]) {

        final String first = "abcdfsdfgdfe";
        final String second = "kkkk";
        System.out.println(getLCS(first.toCharArray(), first.length(), second.toCharArray(), second.length()));

    }

}
