package p232.queue.by.stacks;

import java.util.Stack;

/**
 * Created by senyuanwang on 15/7/7.
 */
public class Solution {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
    }

}

class MyQueue {
    private Stack<Integer> a = new Stack<>(), b = new Stack<>(), c = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        a.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!a.empty()) {
            c.push(a.pop());
        }

        while(!b.empty()) {
            c.push(b.pop());
        }

        c.pop();

        while(!c.empty()) {
            b.push(c.pop());
        }

    }

    // Get the front element.
    public int peek() {
        while(!a.empty()) {
            c.push(a.pop());
        }

        while(!b.empty()) {
            c.push(b.pop());
        }

        int x = c.peek();

        while(!c.empty()) {
            b.push(c.pop());
        }

        return x;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return a.empty() && b.empty();
    }
}