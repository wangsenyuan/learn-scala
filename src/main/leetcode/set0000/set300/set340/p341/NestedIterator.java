package set0000.set300.set340.p341;

import set0000.set300.set330.p339.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by senyuanwang on 16/4/5.
 */
public class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        toIntList(nestedList, list);
        iter = list.iterator();
    }

    private void toIntList(List<NestedInteger> nestedIntegers, List<Integer> list) {
        for (NestedInteger nestedInteger : nestedIntegers) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                toIntList(nestedInteger.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

class NestedIterator2 implements Iterator<Integer> {
    private Stack<List<NestedInteger>> stack;

    public NestedIterator2(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        stack.push(nestedList);
    }


    @Override
    public Integer next() {
        List<NestedInteger> list = stack.pop();
        NestedInteger head = list.remove(0);
        if (!list.isEmpty()) {
            stack.push(list);
        }

        return dfs(head, stack);
    }

    private Integer dfs(NestedInteger head, Stack<List<NestedInteger>> stack) {
        if (head.isInteger()) {
            return head.getInteger();
        }

        List<NestedInteger> children = head.getList();

        NestedInteger first = children.remove(0);
        if (!children.isEmpty()) {
            stack.push(children);
        }
        return dfs(first, stack);
    }

    @Override
    public boolean hasNext() {
        List<NestedInteger> head = stack.peek();
        while (!stack.isEmpty() && head.isEmpty()) {
            stack.pop();
            head = stack.peek();
        }
        return !stack.isEmpty();
    }
}
