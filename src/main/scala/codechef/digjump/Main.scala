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
      val last = Array.fill(10)(-1)
      val dist = Array.fill(10, 10)(n + 1)
      val best = Array.fill(10, 10)(-1)

      for {
        i <- 0 until n
        x = digits(i)
      } {
        if (first(x) < 0) {
          first(x) = i
        }
        last(x) = i
        for {
          y <- 0 until 10
          if (last(y) >= 0)
          if (i - last(y) < dist(x)(y))
        } {
          dist(x)(y) = i - last(y)
          dist(y)(x) = i - last(y)
          best(x)(y) = i
          best(y)(x) = last(y)
        }
      }

      val cost = Array.fill(10)(n + 1)
      for {
        x <- 0 until 10
        if first(x) >= 0
      } {
        cost(x) = first(x) + 1
      }
      val jumpTo = Array.fill(10)(-1)
      val visited = Array.fill(10)(false)
      var cur = digits(0)
      visited(cur) = true
      while (cur != digits(n - 1)) {
        for {
          x <- 0 until 10
          if !visited(x)
          if cost(x) >= cost(cur) + dist(cur)(x) + 1
        } {
          cost(x) = cost(cur) + dist(cur)(x) + 1
          jumpTo(x) = cur
        }

        var y = -1
        var minCost = n + 1
        for {
          x <- 0 until 10
          if !visited(x)
          if cost(x) < minCost
        } {
          y = x
          minCost = cost(x)
        }

        visited(y) = true
        cur = y
      }

      if (first(cur) == n - 1 || best(cur)(jumpTo(cur)) == n - 1) {
        cost(cur) - 1
      } else {
        cost(cur)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val digits = StdIn.readLine().trim.map(_ - '0').toArray

    println(findShortestMoves(digits))
  }
}
