package set300.set340.p347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangsenyuan on 5/2/16.
 */
public class Solution1 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length < k) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);

        List<Tuple2> list = new ArrayList<>();
        Tuple2 prev = new Tuple2(nums[0], 1);
        list.add(prev);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == prev._1) {
                prev._2 += 1;
            } else {
                prev = new Tuple2(x, 1);
                list.add(prev);
            }
        }
        Collections.sort(list, (a, b) -> b._2 - a._2);

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            Tuple2 tuple2 = list.get(i);
            result.add(tuple2._1);
        }

        return result;
    }


    static class Tuple2 {
        int _1;
        int _2;

        public Tuple2(int _1, int _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }
}
