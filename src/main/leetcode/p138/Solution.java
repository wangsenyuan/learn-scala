package p138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsenyuan on 8/20/16.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode tmp = head;
        Map<RandomListNode, RandomListNode> copied = new HashMap<>();
        Map<RandomListNode, List<RandomListNode>> needToLink = new HashMap<>();
        RandomListNode newHead = null;
        RandomListNode prev = null;
        while (tmp != null) {
            RandomListNode cp = new RandomListNode(tmp.label);
            if (newHead == null) {
                newHead = cp;
            }

            if (prev != null) {
                prev.next = cp;
            }
            prev = cp;

            copied.put(tmp, cp);
            if (tmp.random != null) {
                if (copied.containsKey(tmp.random)) {
                    cp.random = copied.get(tmp.random);
                } else {
                    if (!needToLink.containsKey(tmp.random)) {
                        needToLink.put(tmp.random, new ArrayList<>());
                    }
                    needToLink.get(tmp.random).add(cp);
                }
            }
            if (needToLink.containsKey(tmp)) {
                List<RandomListNode> linkThis = needToLink.remove(tmp);
                for (RandomListNode node : linkThis) {
                    node.random = cp;
                }
            }

            tmp = tmp.next;
        }

        return newHead;
    }
}
