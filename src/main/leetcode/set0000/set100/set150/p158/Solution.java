package set0000.set100.set150.p158;

/**
 * Created by wangsenyuan on 8/26/16.
 */
public class Solution {
    /* The read4 API is defined in the parent class Reader4. */
    int read4(char[] buf) {
        return 0;
    }

    private char[] cache = new char[4];
    private int p;
    private int sz;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (p == 0) {
                sz = read4(cache);
            }

            while (i < n && p < sz) {
                buf[i++] = cache[p++];
            }
            if (p == sz) {
                p = 0;
            }
            if (sz == 0) {
                break;
            }
        }

        return i;
    }
}
