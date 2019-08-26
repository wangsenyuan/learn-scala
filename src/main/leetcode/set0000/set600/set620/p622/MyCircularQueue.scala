package set0000.set600.set620.p622

class MyCircularQueue(_k: Int) {
  val array = Array.fill(_k)(0)
  var capacity = _k
  var size = 0
  var front = 0
  var end = 0
  /** Initialize your data structure here. Set the size of the queue to be k. */


  /** Insert an element into the circular queue. Return true if the operation is successful. */
  def enQueue(value: Int): Boolean = {
    if (isFull()) {
      false
    } else {
      array(end) = value
      end = (end + 1) % capacity
      size += 1
      true
    }
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  def deQueue(): Boolean = {
    if (isEmpty()) {
      false
    } else {
      array(front) = -1
      front = (front + 1) % capacity
      size -= 1
      true
    }
  }

  /** Get the front item from the queue. */
  def Front(): Int = {
    if (isEmpty()) {
      -1
    } else {
      array(front)
    }
  }

  /** Get the last item from the queue. */
  def Rear(): Int = {
    if (isEmpty()) {
      -1
    } else {
      val pos = (end - 1 + capacity) % capacity
      array(pos)
    }
  }

  /** Checks whether the circular queue is empty or not. */
  def isEmpty(): Boolean = {
    size == 0
  }

  /** Checks whether the circular queue is full or not. */
  def isFull(): Boolean = {
    size == capacity
  }

}
