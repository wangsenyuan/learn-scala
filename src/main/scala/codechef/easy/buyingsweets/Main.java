package codechef.easy.buyingsweets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wangsenyuan on 8/15/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bi = new BufferedReader(new InputStreamReader(System.in))) {
            String tLine = bi.readLine();
            int t = Integer.parseInt(tLine);
            while (t > 0) {
                String line = bi.readLine();
                String[] nx = line.split("\\s+");
                int n = Integer.parseInt(nx[0]);
                int x = Integer.parseInt(nx[1]);
                int[] bankNotes = new int[n];
                line = bi.readLine();
                String[] notes = line.split("\\s+");
                for (int i = 0; i < n; i++) {
                    bankNotes[i] = Integer.parseInt(notes[i]);
                }
                int r = play(x, bankNotes);
                System.out.println(r);
                t--;
            }
        }
    }

    private static int play(int x, int[] bankNotes) {
        int sum = 0;
        for (int bankNote : bankNotes) {
            sum += bankNote;
        }

        if (sum < x) {
            return -1;
        }

        int k = sum / x;
        int r = sum - k * x;
        if (r == 0) {
            return k;
        }

        for (int bankNote : bankNotes) {
            if (bankNote <= r) {
                return -1;
            }
        }

        return k;
    }
}
