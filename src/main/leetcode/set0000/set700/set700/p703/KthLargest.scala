package set0000.set700.set700.p703

import java.util

class KthLargest(_k: Int, _nums: Array[Int]) {
  val treeMap = new util.TreeMap[Int, Int]

  var size = _k min _nums.size
  val nums = _nums.sorted.reverse

  for {
    i <- 0 until size
  } {
    addValue(nums(i))
  }

  def addValue(value: Int): Unit = {
    if (treeMap.containsKey(value)) {
      treeMap.put(value, treeMap.get(value) + 1)
    } else {
      treeMap.put(value, 1)
    }
  }

  def add(value: Int): Int = {
    if (size < _k) {
      addValue(value)
      size += 1
      treeMap.firstKey()
    } else {
      val minValue = treeMap.firstKey()
      if (minValue >= value) {
        minValue
      } else {
        addValue(value)
        val minCnt = treeMap.get(minValue)
        if (minCnt == 1) {
          treeMap.remove(minValue)
          treeMap.firstKey()
        } else {
          treeMap.put(minValue, minCnt - 1)
          minValue
        }
      }
    }
  }

}
