package encode.decode.strings.p271;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/29.
 */
public class Codec {
    private static final int LEN = 32;
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append(padding(0));
                continue;
            }
            sb.append(padding(str.length()));
            sb.append(str);
        }

        return sb.toString();
    }

    private String padding(int length) {
        return String.format("%0" + LEN + "d", length);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int i = 0;
        for (; i < cs.length; ) {
            int count = readLength(cs, i);
            sb.setLength(0);
            int j = i + LEN;
            for (; j < i + LEN + count; j++) {
                sb.append(cs[j]);
            }
            strs.add(sb.toString());
            i = j;
        }

        return strs;
    }

    private int readLength(char[] cs, int start) {
        int val = 0;
        for (int i = start; i < start + LEN; i++) {
            int x = cs[i] - '0';
            val = val * 10 + x;
        }

        return val;
    }

    public static void main(String[] args) {
        String[] array = {"63/Rc", "h", "BmI3FS~J9#vmk", "7uBZ?7*/", "24h+X", "O "};
        List<String> strs = new ArrayList<>();
        for (String str : array) {
            strs.add(str);
        }
        Codec codec = new Codec();
        String encoded = codec.encode(strs);
        System.out.println(encoded);
        List<String> decoded = codec.decode(encoded);
        System.out.println(decoded.size());
        System.out.println(decoded);
    }
}
