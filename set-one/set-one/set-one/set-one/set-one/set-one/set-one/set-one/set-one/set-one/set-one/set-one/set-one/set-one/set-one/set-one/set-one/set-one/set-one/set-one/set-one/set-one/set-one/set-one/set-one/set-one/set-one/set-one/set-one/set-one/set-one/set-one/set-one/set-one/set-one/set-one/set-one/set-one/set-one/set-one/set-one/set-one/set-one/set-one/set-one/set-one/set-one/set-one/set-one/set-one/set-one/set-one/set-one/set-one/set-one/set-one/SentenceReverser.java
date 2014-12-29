package pack1;

public class SentenceReverser {

    static String getReverse(final String input) {
        final char inputCharArray[] = input.toCharArray();
        int first = 0;
        int last = input.length() - 1;
        char temp;
        while (first < last) {
            temp = inputCharArray[first];
            inputCharArray[first] = inputCharArray[last];
            inputCharArray[last] = temp;
            first++;
            last--;
        }
        return new String(inputCharArray);
    }

    public static void main(final String args[]) {

        final String inputString = "This is hello world";
        final String[] inputArrayOfString = inputString.split(" ");
        final StringBuffer sb = new StringBuffer();
        for (final String s : inputArrayOfString) {
            sb.append(getReverse(s));
            sb.append(" ");
        }
        System.out.println(getReverse("Anirban"));
        System.out.println(sb.toString());
        System.out.println(getReverse(sb.toString()));
    }

}
