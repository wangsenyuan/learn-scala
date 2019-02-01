package set300.set300.p306;

/**
 * Created by wangsenyuan on 26/10/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //System.out.println(solution.isAdditiveNumber("112358"));
        //System.out.println(solution.isAdditiveNumber("199100199"));
        //System.out.println(solution.isAdditiveNumber("10"));
        System.out.println(solution1.isAdditiveNumber("8917"));
    }

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            String a = num.substring(0, i);
            for (int j = i + 1; j < num.length(); j++) {
                if (j - i > 1 && num.charAt(i) == '0') {
                    break;
                }
                String b = num.substring(i, j);
                if (isAdditive(a, b, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String a, String b, String left) {
        if (left.length() == 0) {
            return true;
        }

        if (left.length() > 1 && left.charAt(0) == '0') {
            return false;
        }

        String c = add(a, b);
        if (!left.startsWith(c)) {
            return false;
        }
        return isAdditive(b, c, left.substring(c.length()));
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int x = 0;
            if (a.length() - 1 - i >= 0) {
                x = a.charAt(a.length() - 1 - i) - '0';
            }
            int y = 0;
            if (b.length() - 1 - i >= 0) {
                y = b.charAt(b.length() - 1 - i) - '0';
            }
            int z = x + y + carry;
            if (z >= 10) {
                sb.append(z - 10);
                carry = 1;
            } else {
                sb.append(z);
                carry = 0;
            }
        }

        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


}
