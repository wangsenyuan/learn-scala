package java8.high.function.ex;

import java.util.function.Function;

/**
 * Created by senyuanwang on 15/10/29.
 */
public class Main {

    public Function<Integer, Integer> makeAdder(int x) {
        return ((Integer y) -> {return x + y;});
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.makeAdder(4).apply(5);
    }

}
