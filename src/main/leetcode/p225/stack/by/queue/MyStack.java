package p225.stack.by.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by senyuanwang on 15/6/12.
 */
public class MyStack {
    private Queue<Integer> first = new LinkedList<>();
    private Queue<Integer> second = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        first.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (first.size() > 0) {
            while (first.size() > 1) {
                second.offer(first.poll());
            }
            first.poll();
        }
        swapQueue();
    }

    // Get the top element.
    public int top() {
        int rt = 0;
        if (first.size() > 0) {
            while (first.size() > 1) {
                second.offer(first.poll());
            }
            rt = first.peek();
        }
//        swapQueue();
        return rt;
    }

    private void swapQueue() {
        Queue<Integer> tmp = first;
        first = second;
        second = tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
        myStack.pop();
        System.out.println(myStack.empty());
    }
}
