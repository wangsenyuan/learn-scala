package codechef.easy.section1.eurstr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        String[] ss = new String[n];
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ss[i] = reader.next();
            buf.append(ss[i]);
            buf.append((char) ('a' + 26));
        }
        StateMachine sa = new StateMachine();
        sa.process(buf.toString());

        int[][] pos = new int[n][];
        for (int i = 0; i < n; i++) {
            pos[i] = new int[ss[i].length()];
            int cur = 0;
            for (int j = 0; j < ss[i].length(); j++) {
                int x = ss[i].charAt(j) - 'a';
                cur = sa.states.get(cur).next[x];
                pos[i][j] = cur;
            }
        }

        StringBuilder res = new StringBuilder();
        int q = reader.nextInt();
        while (q-- > 0) {
            int p = reader.nextInt();
            p--;
            int d = reader.nextInt();
            if (d > ss[p].length()) {
                res.append(0);
            } else {
                res.append(sa.count[pos[p][d - 1]]);
            }
            res.append('\n');
        }

        System.out.print(res);
    }

    static class State {
        int link;
        int len;
        int[] next;

        public State() {
            this.len = 0;
            this.link = -1;
            this.next = new int[27];
            for (int i = 0; i < 27; i++) {
                this.next[i] = -1;
            }
        }
    }


    static class StateMachine {
        private ArrayList<State> states;
        private int last;

        private int[] count;

        public StateMachine() {
            this.states = new ArrayList<>();
            this.last = this.createState();
        }

        private void extend(char c) {
            int cur = createState();

            this.states.get(cur).len = states.get(last).len + 1;
            int p = this.last;
            int x = c - 'a';
            while (p >= 0 && states.get(p).next[x] < 0) {
                states.get(p).next[x] = cur;
                p = states.get(p).link;
            }
            if (p < 0) {
                states.get(cur).link = 0;
            } else {
                int q = states.get(p).next[x];
                if (states.get(p).len + 1 == states.get(q).len) {
                    states.get(cur).link = q;
                } else {
                    int clone = createState();
                    states.get(clone).len = states.get(p).len + 1;
                    states.get(clone).link = states.get(q).link;
                    for (int j = 0; j < 27; j++) {
                        states.get(clone).next[j] = states.get(q).next[j];
                    }
                    states.get(q).link = clone;
                    states.get(cur).link = clone;
                }
            }
            this.last = cur;
        }

        private int createState() {
            int pos = this.states.size();
            this.states.add(new State());
            return pos;
        }

        private void dfs(int u) {
            if (this.count[u] > 0) {
                return;
            }
            this.count[u]++;
            State cur = this.states.get(u);
            for (int i = 0; i < 26; i++) {
                int v = cur.next[i];
                if (v >= 0) {
                    dfs(v);
                    this.count[u] += this.count[v];
                }
            }
        }

        public void process(String s) {
            for (char c : s.toCharArray()) {
                this.extend(c);
            }
            this.count = new int[states.size()];

            this.dfs(0);
        }
    }
}
