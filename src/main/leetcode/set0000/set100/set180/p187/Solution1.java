package set0000.set100.set180.p187;

/**
 * Created by senyuanwang on 15/3/14.
 * <p>
 * <p>
 * from https://leetcode.com/discuss/25411/java-program-in-225ms-could-be-even-faster
 */

import java.util.*;

public class Solution1 {

    private static byte codebook[];
    private static final byte textbook[] = {'A', 'C', 'G', 'T'};

    static {
        codebook = new byte[256];
        codebook['A'] = 0;
        codebook['C'] = 1;
        codebook['G'] = 2;
        codebook['T'] = 3;
    }

    private byte dnaBuf[] = new byte[10];

    private String decode(int c) {
        for (int i = 0; i < 10; i++) {
            dnaBuf[i] = textbook[(c & 0xc0000) >> 18];
            c <<= 2;
        }
        return new String(dnaBuf);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rL = new ArrayList<>();
        byte dnaMap[] = new byte[1 << 20];
        int i;
        if (s == null || s.length() <= 10)
            return rL;
        int code = 0;
        for (i = 0; i < 9; i++) {
            code = ((code << 2) + codebook[s.charAt(i)]) & 0xfffff;
        }

        for (; i < s.length(); i++) {
            code = ((code << 2) + codebook[s.charAt(i)]) & 0xfffff;
            if (dnaMap[code] == 0) {
                dnaMap[code]++;
            } else if (dnaMap[code] == 1) {
                dnaMap[code]++;
                rL.add(decode(code));
            }
        }
        return rL;
    }
}
