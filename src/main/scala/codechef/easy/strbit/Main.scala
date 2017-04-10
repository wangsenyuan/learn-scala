package codechef.easy.strbit

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/04/2017.
  */
object Main {

  def smart(n: Int, k: Int, cs: String) = {
    val xs = Array.fill(n + 1)(false)
    var state = 0
    var ans = 0
    var i = 0
    while (i < n) {
      if (xs(i)) {
        state = 1 - state
      }

      if ((state == 0 && cs(i) == 'R') || (state == 1 && cs(i) == 'G')) {
        xs((i + k) min n) = true
        ans += 1
        state = 1 - state
      }

      i += 1
    }
    ans
  }

  def bit(n: Int, k: Int, cs: String) = {
    val xs = Array.fill(n + 1)(0)

    def update(i: Int, v: Int): Unit = {
      var idx = i + 1
      while (idx <= n) {
        xs(idx) += v
        idx += idx & (-idx)
      }
    }

    def query(i: Int): Int = {
      var ans = 0
      var idx = i + 1
      while (idx > 0) {
        ans += xs(idx)
        idx -= idx & (-idx)
      }
      ans
    }

    var ans = 0
    var i = 0
    while (i < n) {
      val x = query(i)
      val flip = (x % 2 == 0 && cs(i) == 'R') || (x % 2 == 1 && cs(i) == 'G')
      if (flip) {
        ans += 1
        update(i, 1)
        if (i + k < n) {
          update(i + k, -1)
        }
      }
      i += 1
    }
    //    println(ans)
    ans
  }


  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val cs = StdIn.readLine()

    val ans = bit(n, k, cs)

    println(ans)

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }
}
