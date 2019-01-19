package set200.set230.p232

class MyQueue() {

  /** Initialize your data structure here. */
  var stack = List.empty[Int]
  var back = List.empty[Int]

  /** Push element x to the back of queue. */
  def push(x: Int) {
    stack = x :: stack
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    while (!stack.isEmpty) {
      back = stack.head :: back
      stack = stack.tail
    }
    val res = back.head
    back = back.tail

    while (!back.isEmpty) {
      stack = back.head :: stack
      back = back.tail
    }

    res
  }

  /** Get the front element. */
  def peek(): Int = {
    var res = 0
    while (!stack.isEmpty) {
      res = stack.head
      back = res :: back
      stack = stack.tail
    }

    while (!back.isEmpty) {
      stack = back.head :: stack
      back = back.tail
    }

    res
  }

  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    stack.isEmpty
  }

}
