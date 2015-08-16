package p258.add.digits;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class Solution {
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }

        int val = 0;
        while(num > 0) {
            val += num % 10;
            num /= 10;
        }
        return addDigits(val);
    }
}
