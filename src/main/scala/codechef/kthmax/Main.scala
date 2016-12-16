package codechef.kthmax

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      var m = firstLine(1)
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val solver = new Solver(nums)
      while (m > 0) {
        m -= 1
        val p = StdIn.readLong()
        val res = solver.query(p)
        println(res)
      }
    }
  }

  class Solver(val nums: Array[Int]) {
    val n = nums.size
    //xs store the original index of the nums, sorting according to the number order;
    val xs = (0 until n).toArray.sortWith {
      (a, b) =>
        val x = nums(a)
        val y = nums(b)
        if (x < y) {
          true
        } else if (x > y) {
          false
        } else {
          a < b
        }
    }

    //ys store the count that nums(ys(i)) is the maximum number in the sub array
    val ys = Array.fill(n + 1)(0L)
    val treeSet = new util.TreeSet[Int]()

    treeSet.add(-1)
    treeSet.add(n)

    var i = n - 1
    while(i >= 0) {
      val j = xs(i)
      val a = treeSet.lower(j)
      val b = treeSet.higher(j)
      ys(n - i) = 1L * (j - a) * (b - j)
      treeSet.add(j)
      i -= 1
    }

    //zs store the total count larger than nums(i) as the maximum number in the sub array
    val zs = Array.fill(n + 1)(0L)
    for {
      i <- 1 to n
    } {
      zs(i) = zs(i - 1) + ys(i)
    }

    def query(p: Long): Int = {
      var l = 0
      var r = n
      while (r - l > 1) {
        val mid = (l + r) / 2
        if (zs(mid) < p) {
          l = mid
        } else {
          r = mid
        }
      }
      nums(xs(n - r))
    }

  }

}