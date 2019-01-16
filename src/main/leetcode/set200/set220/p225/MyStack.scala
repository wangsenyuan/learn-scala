package set200.set220.p225

import scala.collection.mutable

class MyStack() {

  /** Initialize your data structure here. */
  val que = mutable.Queue.empty[Int]
  val bak = mutable.Queue.empty[Int]

  /** Push element x onto stack. */
  def push(x: Int) {
    que.enqueue(x)
  }

  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = {
    while (que.size > 1) {
      bak.enqueue(que.dequeue())
    }
    val res = que.dequeue()

    while (bak.size > 0) {
      que.enqueue(bak.dequeue())
    }

    res
  }

  /** Get the top element. */
  def top(): Int = {
    var res = 0
    while (que.size > 0) {
      res = que.dequeue()
      bak.enqueue(res)
    }

    while (bak.size > 0) {
      que.enqueue(bak.dequeue())
    }

    res
  }

  /** Returns whether the stack is empty. */
  def empty(): Boolean = {
    que.isEmpty
  }

}
