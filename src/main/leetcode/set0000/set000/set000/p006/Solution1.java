package set0000.set000.set000.p006;

/**
 * Created by senyuanwang on 15/4/12.
 */
public class Solution1 {

    public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int delta = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sbs[index].append(c);
            index += delta;
            if (index == nRows) {
                delta = -1;
                index = Math.max(0, nRows - 2);
            } else if (index < 0) {
                delta = 1;
                index = Math.min(nRows - 1, 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
