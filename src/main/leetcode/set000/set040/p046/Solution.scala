package set000.set040.p046

import scala.collection.mutable.ListBuffer

object Solution {

  def permute(nums: Array[Int]): List[List[Int]] = {
    if (nums.length <= 1) {
      List(nums.toList)
    } else {
      val last = nums.last
      val res = permute(nums.init)
      res.flatMap(lst => insert(lst, last))
    }
  }

  private def insert(lst: List[Int], num: Int): Seq[List[Int]] = {
    val vec = lst.toVector

    (0 to vec.size).map(i => {
      val (left, right) = vec.splitAt(i)
      (left ++ Vector(num) ++ right).toList
    })
  }

  def permute1(nums: Array[Int]): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]

    val arr = nums.sorted
    val n = arr.length
    var total = fact(n)

    while (total > 0) {
      res += arr.toList

      nextPermute(arr)

      total -= 1
    }

    res.toList
  }

  private def fact(n: Int): Int = {
    def go(n: Int, cur: Int): Int = {
      if (n == 1) {
        cur
      } else {
        go(n - 1, n * cur)
      }
    }

    go(n, 1)
  }

  private def nextPermute(arr: Array[Int]) = {
    val n = arr.length
    var i = n - 2
    while (i >= 0 && arr(i) > arr(i + 1)) {
      i -= 1
    }
    //arr(i) > arr(i + 1) or i < 0
    if (i < 0) {
      swapRange(arr, 0, n - 1)
    } else {
      var j = i + 1
      var k = j + 1
      while (k < n) {
        if (arr(k) > arr(i) && arr(k) < arr(j)) {
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
