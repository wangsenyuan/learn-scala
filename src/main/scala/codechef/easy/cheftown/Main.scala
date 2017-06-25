package codechef.easy.cheftown

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 25/06/2017.
  */
object Main {

  def interesting(sum: Long, min: Long, max: Long, w: Int): Boolean = {
    max == min + w - 1 && sum == (min + max) * w / 2
  }

  def solve1(heights: Array[Long], n: Int, w: Int): Int = {
    var ans = 0
    val parade = mutable.TreeSet.empty[Long]
    var sum = 0L
    var j = 0
    var i = 0
    while (i < n) {
      val height = heights(i)
      if (parade.contains(height)) {
        parade.clear()
        sum = 0
        j = i
      }

      parade += height
      sum += height


      if (parade.size == w) {
        val min = parade.head
        val max = parade.last
        if (interesting(sum, min, max, w)) {
          ans += 1
        }
        parade -= heights(j)
        sum -= heights(j)
        j += 1
      }

      i += 1
    }

    ans
  }

  class Queue(sz: Int, gt: (Int, Int) => Boolean) {
    val dq = Array.fill(sz)(0)
    var a = 0
    var b = -1
    val iq = Array.fill(sz)(0)
    var c = 0
    var d = -1

    def push(ele: Int): Unit = {
      while (b >= a && gt(dq(b), ele)) {
        b -= 1
      }
      b += 1
      dq(b) = ele
      d += 1
      iq(d) = ele
    }

    def pop(): Int = {
      val ele = iq(c)
      c += 1
      if (ele == dq(a)) {
        a += 1
      }
      ele
    }

    def head(): Int = {
      dq(a)
    }
  }

  def solve(heights: Array[Int], n: Int, w: Int): Int = {
    val minQueue = new Queue(n, (a, b) => a > b)
    val maxQueue = new Queue(n, (a, b) => a < b)

    var i = 0
    while (i < w) {
      minQueue.push(heights(i))
      maxQueue.push(heights(i))
      i += 1
    }

    var ans = 0
    while (i <= n) {
      val mi = minQueue.head()
      val ma = maxQueue.head()
      if (ma == mi + w - 1) {
        ans += 1
      }
      minQueue.pop()
      maxQueue.pop()
      if (i < n) {
        minQueue.push(heights(i))
        maxQueue.push(heights(i))
      }
      i += 1
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)

    val n = firstLine(0)
    val w = firstLine(1)

    val heights = StdIn.readLine().split("\\s+").map(_.toInt)

    val ans = solve(heights, n, w)

    println(ans)
  }
}
