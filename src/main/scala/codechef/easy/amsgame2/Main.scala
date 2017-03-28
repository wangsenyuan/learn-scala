package codechef.easy.amsgame2

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/27.
  */
object Main {

  def fastSquare(x: Int, n: Int): Long = {
    if (n == 0) {
      1
    } else {
      val y = fastSquare(x, n / 2)
      val z = y * y
      if (n % 2 == 1) {
        x * z
      } else {
        z
      }
    }
  }

  def solve() = {
    val n = StdIn.readInt()

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    def gcd(a: Int, b: Int): Int = {
      if (b == 0) {
        a
      } else {
        gcd(b, a % b)
      }
    }

    val cache = mutable.Map[(Int, Int), Long]()

    def process(i: Int, g: Int): Long = {
      val key = (i, g)
      cache.get(key) match {
        case Some(res) => res
        case None =>
          val res =
            if (g == 1) {
              fastSquare(2, n - i)
            } else if (i == n) {
              0L
            } else {
              process(i + 1, g) + process(i + 1, gcd(g, nums(i)))
            }
          cache(key) = res
          res
      }
    }

    var ans = 0L

    var i = 0
    while (i < n) {
      ans += process(i + 1, nums(i))
      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      solve()
      t -= 1
    }
  }
}
