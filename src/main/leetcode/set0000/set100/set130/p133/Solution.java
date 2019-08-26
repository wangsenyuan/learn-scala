package set0000.set100.set130.p133;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 8/19/16.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return cloneGraphRecursive(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneGraphRecursive(UndirectedGraphNode node,
        Map<Integer, UndirectedGraphNode> visited) {
        if (visited.containsKey(node.label)) {
            return visited.get(node.label);
        }

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        visited.put(copy.label, copy);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraphRecursive(neighbor, visited));
        }
        return copy;
    }
}
