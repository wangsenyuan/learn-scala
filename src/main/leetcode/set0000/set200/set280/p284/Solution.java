package set0000.set200.set280.p284;

import java.util.Iterator;

public class Solution {
}


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer head;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.head = getHead(iterator);
    }

    private Integer getHead(Iterator<Integer> iterator) {
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return null;
        }
        return iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = head;
        head = getHead(this.iterator);
        return res;
    }


    @Override
    public boolean hasNext() {
        return head != null;
    }
}
