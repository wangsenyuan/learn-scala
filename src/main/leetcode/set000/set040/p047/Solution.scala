package set000.set040.p047

import scala.collection.mutable.ListBuffer

object Solution {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    val arr = nums.sorted
    val res = ListBuffer.empty[List[Int]]

    res += arr.toList
    nextPermute(arr)
    while (!sorted(arr)) {
      res += arr.toList
      nextPermute(arr)
    }

    res.toList
  }

  private def sorted(arr: Array[Int]): Boolean = {
    arr.zip(arr.tail).forall(x => x._1 <= x._2)
  }


  private def nextPermute(arr: Array[Int]) = {
    val n = arr.length
    var i = n - 2
    while (i >= 0 && arr(i) >= arr(i + 1)) {
      i -= 1
    }
    //arr(i) > arr(i + 1) or i < 0
    if (i < 0) {
      swapRange(arr, 0, n - 1)
    } else {
      var j = i + 1
      var k = j + 1
      while (k < n) {
        if (arr(k) > arr(i) && arr(k) <= arr(j)) {
          j = k
        }
        k += 1
      }
      swap(arr, i, j)
      swapRange(arr, i + 1, n - 1)
    }
  }

  private def swapRange(arr: Array[Int], start: Int, end: Int): Unit = {
    var i = start
    var j = end
    while (i < j) {
      swap(arr, i, j)
      i += 1
      j -= 1
    }
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }
}
