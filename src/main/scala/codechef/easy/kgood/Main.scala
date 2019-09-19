package codechef.easy.kgood

import scala.io.StdIn

/**
 * Created by wangsenyuan on 02/04/2017.
 */
object Main {

  def binarySearch(xs: Array[Int], x: Int): Int = {
    var i = 0
    var j = xs.length
    while (i < j) {
      val k = i + (j - i) / 2
      if (xs(k) <= x) {
        i = k + 1
      } else {
        j = k
      }
    }
    i
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val str = line(0)
    val k = line(1).toInt

    val n = str.length
    val count = Array.fill(26)(0)

    var i = 0
    while (i < n) {
      count(str(i) - 'a') += 1
      i += 1
    }
    val valid = count.filter(_ > 0).sorted

    var prev = 0
    var ans = -1
    i = 0
    while (i < valid.length) {
      val x = valid(i)
      //j is the first index that greater than x + k
      var tmp = prev
      var j = binarySearch(valid, x + k)
      while (j < valid.length) {
        tmp += valid(j) - x - k
        j += 1
      }
      if (ans == -1 || tmp < ans) {
        ans = tmp
      }
      prev += valid(i)
      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
