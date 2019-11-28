package set1000.set1100.set1170.p1172

import java.util

class DinnerPlates(_capacity: Int) {
  val stacks = Array.ofDim[Stack](100001)
  var sz = 0

  val notFull = new util.TreeMap[Int, Stack]()

  def push(v: Int) {
    if (notFull.isEmpty) {
      val stack = new Stack(_capacity, sz)
      stacks(sz) = stack
      sz += 1
      notFull.put(stack.index, stack)
    }

    val first = notFull.ceilingEntry(0)
    // first can't be null
    val theStack = first.getValue
    theStack.push(v)

    if (theStack.isFull()) {
      notFull.remove(theStack.index)
    }
  }

  def pop(): Int = {
    if (stacks.isEmpty) {
      -1
    } else {

      while (sz > 0 && stacks(sz - 1).isEmpty()) {
        notFull.remove(sz - 1)
        sz -= 1
      }
      if (sz == 0) {
        -1
      } else {
        val stack = stacks(sz - 1)
        val r = stack.pop()
        r
      }
    }
  }

  def popAtStack(index: Int): Int = {
    if (index >= sz) {
      -1
    } else {
      val stack = stacks(index)
      if (stack.isEmpty()) {
        -1
      } else {
        val res = stack.pop()
        notFull.put(index, stack)
        res
      }
    }
  }

  class Stack(capacity: Int, val index: Int) {
    val arr = Array.ofDim[Int](capacity)
    var sz = 0

    def push(v: Int): Unit = {
      arr(sz) = v
      sz += 1
    }

    def pop(): Int = {
      val res = arr(sz - 1)
      sz -= 1
      res
    }

    def isEmpty() = sz == 0

    def isFull() = sz == capacity
  }

}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * var obj = new DinnerPlates(capacity)
 * obj.push(`val`)
 * var param_2 = obj.pop()
 * var param_3 = obj.popAtStack(index)
 */
