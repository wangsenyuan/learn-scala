package p443;

public class Solution {
    public static int compress(char[] chars) {
        int n = chars.length;
        int x = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            int cnt = j - i;
            chars[x++] = chars[i];

            if (cnt > 1) {
                String str = String.valueOf(cnt);
                for (int k = 0; k < str.length(); k++) {
                    chars[x++] = str.charAt(k);
                }
            }

            i = j;
        }
        return x;
    }

    public static void main(String[] args) {
        char[] chars = {'G', 't', 'W', 'Y', 'v', '&', ':', 'd', '#', 'k'};
        //        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int res = compress(chars);
        for (int i = 0; i < res; i++) {
            System.out.print(chars[i] + ' ');
        }
    }
}
