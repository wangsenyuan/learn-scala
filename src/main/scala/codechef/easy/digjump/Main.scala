package codechef.easy.digjump

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/4.
  */
object Main {

  val INF = 1000000;

  def findShortestMoves(digits: Array[Int]): Int = {
    val n = digits.length
    if (n <= 1) {
      0
    } else if (digits(0) == digits(n - 1)) {
      1
    } else {
      val first = Array.fill(10)(-1)
      val last = Array.fill(10)(-INF)
      val dist = Array.fill(10, 10)(INF)
      val best = Array.fill(10, 10)(-1)
      val cost = Array.fill(10)(INF)

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
          val d = i - last(y)
          if (d < INF && d <= dist(x)(y)) {
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
      val lastDigit = digits(n - 1)
      while (cur != lastDigit) {
        visited(cur) = true

        var x = 0
        while (x < 10) {
          if (!visited(x) && cost(x) >= cost(cur) + dist(cur)(x) + 1) {
            cost(x) = cost(cur) + dist(cur)(x) + 1
            jumpTo(x) = cur
          }
          x += 1
        }

        var y = -1
        var minCost = INF
        x = 0
        while (x < 10) {
          if (!visited(x) && cost(x) < minCost) {
            y = x
            minCost = cost(x)
          }
          x += 1
        }
        cur = y
      }


      if (first(lastDigit) == n - 1 || (jumpTo(lastDigit) >= 0 && best(lastDigit)(jumpTo(lastDigit)) == n - 1)) {
        cost(lastDigit) - 1
      } else {
        cost(lastDigit)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val digits = StdIn.readLine().takeWhile(p => p >= '0' && p <= '9').map(_ - '0').toArray

    println(findShortestMoves(digits))
  }
}
