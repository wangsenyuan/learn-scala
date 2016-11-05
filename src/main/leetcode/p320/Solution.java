package p320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by senyuanwang on 15/12/22.
 */
public class Solution {

    public List<String> generateAbbreviations(String word) {
        return go("", 0, false, word);
    }

    private List<String> go(String prev, int index, boolean abbr, String word) {
        int n = word.length();
        if (index == n) {
            return Arrays.asList(prev);
        }
        List<String> list = new ArrayList<>();
        if (!abbr) {
            for (int i = index + 1; i <= n; i++) {
                list.addAll(go(prev + (i - index), i, true, word));
            }
        }

        list.addAll(go(prev + word.charAt(index), index + 1, false, word));
        return list;
    }
}
