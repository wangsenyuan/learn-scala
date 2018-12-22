package set000.set080.p089;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 16/7/31.
 */
public class Solution1 {
    public List<Integer> grayCode(int n) {
        int m = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<Integer>(m);
        for (int i = 0; i < m; i++) {
            int temp = i >> 1;
            list.add(temp ^ i);
        }
        return list;
    }
}
