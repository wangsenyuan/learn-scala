package set0000.set600.set640.p641

class MyCircularDeque(_k: Int) {
  /** Initialize your data structure here. Set the size of the deque to be k. */
  val capacity = _k
  var size = 0
  var front = 0
  var rear = 0
  val array = Array.fill(capacity)(-1)

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  def insertFront(value: Int): Boolean = {
    if (isFull()) {
      false
    } else {
      front = (front - 1 + capacity) % capacity
      array(front) = value
      size += 1
      true
    }
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  def insertLast(value: Int): Boolean = {
    if (isFull()) {
      false
    } else {
      array(rear) = value
      rear = (rear + 1) % capacity
      size += 1
      true
    }
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  def deleteFront(): Boolean = {
    if (isEmpty()) {
      false
    } else {
      array(front) = -1
      front = (front + 1) % capacity
      size -= 1
      true
    }
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  def deleteLast(): Boolean = {
    if (isEmpty()) {
      false
    } else {
      rear = (rear - 1 + capacity) % capacity
      size -= 1
      true
    }
  }

  /** Get the front item from the deque. */
  def getFront(): Int = {
    if (isEmpty()) {
      -1
    } else {
      array(front)
    }
  }

  /** Get the last item from the deque. */
  def getRear(): Int = {
    if (isEmpty()) {
      -1
    } else {
      val pos = (rear - 1 + capacity) % capacity
      array(pos)
    }
  }

  /** Checks whether the circular deque is empty or not. */
  def isEmpty(): Boolean = {
    size == 0
  }

  /** Checks whether the circular deque is full or not. */
  def isFull(): Boolean = {
    size == capacity
  }
}
