package largestnumber;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class SolutionV8 {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public static String largestNumber(int[] num) {
        IntStream xs = Arrays.stream(num);
        Stream<String> ys = xs.mapToObj(x -> x + "");
        Stream<String> sorted = ys.sorted((a, b) -> (b + a).compareTo(a + b));
        String concated = sorted.reduce("", (a, b) -> a + b);

        if (concated.startsWith("0")) {
            return "0";
        }
        return concated;
    }
}
