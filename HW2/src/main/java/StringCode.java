import java.util.HashSet;

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A run is a series of adjacent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int maxLen = 1;
        int curLen = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }

    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * Digits at the end are ignored.
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int count = c - '0';
                if (i + 1 < str.length()) {
                    char next = str.charAt(i + 1);
                    for (int k = 0; k < count; k++) {
                        sb.append(next);
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) return false;
        if (a.length() < len || b.length() < len) return false;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int j = 0; j <= b.length() - len; j++) {
            if (set.contains(b.substring(j, j + len))) {
                return true;
            }
        }
        return false;
    }



}
