package set100.set130.p133;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 8/19/16.
 */

public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
