package set700.set700.p703

class KthLargest2(_k: Int, _nums: Array[Int]) {
  val nums = _nums.sorted.reverse
  var size = _k min nums.size

  val heap = new MinHeap(_k)
  for {
    i <- 0 until size
  } {
    heap.add(nums(i))
  }

  def add(value: Int): Int = {
    if (size < _k) {
      heap.add(value)
      size += 1
    } else {
      val minValue = heap.getMin()
      if (minValue < value) {
        heap.removeMin()
        heap.add(value)
      }
    }

    heap.getMin()
  }
}

class MinHeap(val capacity: Int) {
  val array = Array.fill(capacity)(0)
  var size = 0

  def add(value: Int): Boolean = {
    if (size == capacity) {
      false
    } else {
      var pos = size
      size += 1

      while (pos > 0 && array((pos - 1) / 2) > value) {
        array(pos) = array((pos - 1) / 2)
        pos = (pos - 1) / 2
      }
      array(pos) = value
      true
    }
  }

  def getMin(): Int = {
    return array(0)
  }

  def removeMin(): Unit = {
    if (size > 0) {
      val last = array(size - 1)
      size -= 1

      var pos = 0
      var found = false
      while (!found && 2 * pos + 1 < size) {
        var child = pos * 2 + 1
        if (child + 1 < size && array(child) > array(child + 1)) {
          child += 1
        }
        if (last > array(child)) {
          array(pos) = array(child)
          pos = child
        } else {
          found = true
        }
      }
      array(pos) = last
    }
  }
}
