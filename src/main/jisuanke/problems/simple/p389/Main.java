package problems.simple.p389;

/**
 * Created by senyuanwang on 15/4/21.
 */
public class Main {

    public static void main(String[] args) {
        int[] flags = new int[1000];

        for (int i = 1; i * 2 < 1000; i++) {
            flags[i * 2] += 1;
        }

        for (int i = 1; i * 3 < 1000; i++) {
            flags[i * 3] += 1;
        }

        for (int i = 1; i * 7 < 1000; i++) {
            flags[i * 7] += 1;
        }

        for(int i = 10; i < 1000; i++) {
            if(flags[i] == 3) {
                System.out.println(i);
            }
        }
    }
}
