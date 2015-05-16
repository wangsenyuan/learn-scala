package problems.simple.p031;


import java.util.*;

/**
 * Created by senyuanwang on 15/5/16.
 */
public class Main {

    static class Node {
        final int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (a != node.a) return false;
            if (b != node.b) return false;
            return c == node.c;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Set<Node> result = new HashSet<Node>();
        dfs(a, b, c, 0, 0, c, result);
        List<Integer> cs = new ArrayList<Integer>(result.size());
        for (Node node : result) {
            if (cs.contains(node.c) || node.a > 0) {
                continue;
            }
            cs.add(node.c);
        }
        Collections.sort(cs);
        for (int i = 0; i < cs.size(); i++) {
            System.out.print(cs.get(i));
            if (i < cs.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void dfs(int A, int B, int C, int a, int b, int c, Set<Node> visited) {
        Node cur = new Node(a, b, c);
        if (visited.contains(cur)) {
            return;
        }
        visited.add(cur);

        //try pour c to a
        if (c > 0 && a < A) {
            int v = min(c, A - a);
            dfs(A, B, C, a + v, b, c - v, visited);
        }

        //try pour a to c
        if (a > 0 && c < C) {
            int v = min(a, C - c);
            dfs(A, B, C, a - v, b, c + v, visited);
        }

        //try pour C to b
        if (c > 0 && b < B) {
            int v = min(c, B - b);
            dfs(A, B, C, a, b + v, c - v, visited);
        }

        //try pour b to c
        if (b > 0 && c < C) {
            int v = min(b, C - c);
            dfs(A, B, C, a, b - v, c + v, visited);
        }

        //try pour a to b
        if (a > 0 && b < B) {
            int v = min(a, B - b);
            dfs(A, B, C, a - v, b + v, c, visited);
        }

        //try pour b to a
        if (b > 0 && a < A) {
            int v = min(b, A - a);
            dfs(A, B, C, a + v, b - v, c, visited);
        }
    }

    public static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }
}
