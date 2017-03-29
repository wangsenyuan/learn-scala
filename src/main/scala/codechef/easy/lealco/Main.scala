package codechef.easy.lealco

import scala.io.StdIn

/**
  * Created by wangsenyuan on 29/03/2017.
  */
object Main {

  def popCount(mask: Int) = {
    var x = mask
    var res = 0
    while (x > 0) {
      // delete the lowest bit
      // like 6 -> 4, or 3 -> 2, or 104 -> 32
      x -= x & -x
      res += 1
    }
    res
  }

  def isGood(bs: Array[Int], k: Int, m: Int): Boolean = {
    var good = true
    var i = 0
    while (good && i + k <= bs.length) {

      val cnt = countMaximum(bs, i, i + k)
      good = cnt < m
      i += 1
    }
    good
  }

  def iterateSubSet(as: Array[Int], n: Int, k: Int, m: Int) = {
    val bs = Array.fill(n)(-1)
    var res = n + 1
    var mask = 0
    while (mask < (1 << n)) {
      val cur = popCount(mask)

      if (cur < res) {
        var i = 0
        while (i < n) {
          if ((mask & (1 << i)) > 0) {
            bs(i) = as(i) + 1
          } else {
            bs(i) = as(i)
          }
          i += 1
        }

        if (isGood(bs, k, m)) {
          res = cur
        }
      }

      mask += 1
    }

    if (res == n + 1) {
      -1
    } else {
      res
    }
  }

  private def countMaximum(xs: Array[Int], i: Int, j: Int): Int = {
    var count = 0
    var max = 0
    var k = i
    while (k < j) {
      if (xs(k) == max) {
        count += 1
      } else if (xs(k) > max) {
        max = xs(k)
        count = 1
      }

      k += 1
    }
    count
  }


  def backTrack(as: Array[Int], n: Int, k: Int, m: Int) = {

    var best = n + 1

    def go(i: Int, res: Int): Unit = {
      if (res < best) {
        if (i == n) {
          best = res
        } else {
          var add = 0
          while (add < 2) {
            as(i) += add

            val maxCount =
              if (i >= k - 1) {
                countMaximum(as, i - k + 1, i + 1)
              } else {
                0
              }

            if (maxCount < m) {
              go(i + 1, res + add)
            }
            as(i) -= add
            add += 1
          }
        }
      }
    }

    go(0, 0)

    if (best == n + 1) {
      -1
    } else {
      best
    }
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)
    val m = line(2)
    val as = StdIn.readLine().split("\\s+").map(_.toInt)


    val res = iterateSubSet(as, n, k, m)
    //    val res = backTrack(as, n, k, m)

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
