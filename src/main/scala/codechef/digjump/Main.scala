package codechef.digjump

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/4.
  */
object Main {

  def findShortestMoves(digits: Array[Int]): Int = {
    val n = digits.length
    if (n <= 1) {
      0
    } else if (digits(0) == digits(n - 1)) {
      1
    } else {
      val first = Array.fill(10)(-1)
      val last = Array.fill(10)(-n - 1)
      val dist = Array.fill(10, 10)(n + 1)
      val best = Array.fill(10, 10)(-1)
      val cost = Array.fill(10)(n + 1)

      var i = 0
      while (i < n) {
        val x = digits(i)
        if (first(x) < 0) {
          first(x) = i
          cost(x) = i + 1
        }
        last(x) = i
        var y = 0
        while (y < 10) {
          if (i - last(y) < dist(x)(y)) {
            dist(x)(y) = i - last(y)
            dist(y)(x) = i - last(y)
            best(x)(y) = i
            best(y)(x) = last(y)
          }
          y += 1
        }
        i += 1
      }

      val jumpTo = Array.fill(10)(-1)
      val visited = Array.fill(10)(false)
      var cur = digits(0)
      visited(cur) = true
      while (cur != digits(n - 1)) {
        var x = 0
        while (x < 10) {
          if (!visited(x) && cost(x) >= cost(cur) + dist(cur)(x) + 1) {
            cost(x) = cost(cur) + dist(cur)(x) + 1
            jumpTo(x) = cur
          }
          x += 1
        }

        var y = -1
        var minCost = n + 1
        x = 0
        while (x < 10) {
          if (!visited(x) && cost(x) < minCost) {
            y = x
            minCost = cost(x)
          }
          x += 1
        }

        visited(y) = true
        cur = y
      }

      if (first(digits(n - 1)) == n - 1 || best(digits(n - 1))(jumpTo(digits(n - 1))) == n - 1) {
        cost(digits(n - 1)) - 1
      } else {
        cost(digits(n - 1))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val digits = StdIn.readLine().takeWhile(p => p >= '0' && p <= '9').map(_ - '0').toArray

    println(findShortestMoves(digits))
  }
}
