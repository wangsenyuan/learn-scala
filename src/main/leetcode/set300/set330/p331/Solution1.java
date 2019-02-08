package set300.set330.p331;

/**
 * Created by senyuanwang on 16/2/4.
 */
public class Solution1 {

    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        char[] cs = new char[ss.length];
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            if (s.equals("#")) {
                cs[i] = '#';
            } else {
                cs[i] = '1';
            }
        }

        return isValid(cs);
    }

    private boolean isValid(char[] cs) {
        int nulls = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            char c = cs[i];
            if (c == '#') {
                nulls += 1;
            } else if (nulls < 2) {
                return false;
            } else {
                nulls -= 1;
            }
        }

        return nulls == 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        //System.out.println(solution.isValidSerialization("#"));
//        System.out.println(solution.isValidSerialization("1,#,#"));
        //System.out.println(solution.isValidSerialization("3,4,#,#,1,#,#"));
        //System.out.println(solution.isValidSerialization("2,#,6,#,#"));
    }
}
