package problems.simple.p037;

import java.util.*;

/**
 * Created by senyuanwang on 15/4/29.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node forest = new Node(Integer.MAX_VALUE, new ArrayList<Node>());
        for (int i = 0; i < n; i++) {
            forest = forest.add(scanner.nextInt());
        }

        Set<String> paths = new HashSet<String>();
        forest.result(paths, "");
        int maxPathLength = 0;
        int maxPathCount = 0;
        for(String path : paths) {
            String[] split = path.split("\\|");
            if(split.length > maxPathLength) {
                maxPathLength = split.length;
                maxPathCount = 1;
            } else if(split.length == maxPathLength) {
                maxPathCount += 1;
            }
        }
        System.out.println((maxPathLength - 2) + " " + maxPathCount);
    }

    private static class Node {
        public final int value;
        public final List<Node> children;

        private Node(int value, List<Node> children) {
            this.value = value;
            this.children = children;
        }

        public Node add(int value) {
            if (value >= this.value) {
                return this;
            }
            List<Node> nodes = new ArrayList<>();
            for (Node child : children) {
                nodes.add(child.add(value));
            }
            nodes.add(new Node(value, new ArrayList<Node>()));
            return new Node(this.value, nodes);
        }

        public void result(Set<String> paths, String path) {
            if (children.isEmpty()) {
                paths.add(path + "|" + this.value);
            } else {
                for (Node node : children) {
                    node.result(paths, path + "|" + this.value);
                }
            }
        }

    }
}
