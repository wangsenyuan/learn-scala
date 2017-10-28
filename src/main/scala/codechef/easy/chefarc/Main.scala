package codechef.easy.chefarc

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val k1 = firstLine(2)
    val k2 = firstLine(3)

    val grid = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      grid(i) = line
      i += 1
    }

    def circle(a: Int, b: Int, r: Int) = {
      val arr = Array.fill[(Int, Int)](4 * r)(null)
      var x = 0
      var i = 0
      while (i < r) {
        val j = r - i
        arr(x) = (a + i) -> (b + j)
        arr(x + 1) = (a + j) -> (b - i)
        arr(x + 2) = (a - i) -> (b - j)
        arr(x + 3) = (a - j) -> (b + i)
        x += 4
        i += 1
      }
      arr
    }

    def bfs(x: Int, y: Int, k: Int, f: Array[Array[Int]]) = {
      val pos = Array.fill[(Int, Int)](m * n)(null)
      var head = 0
      var tail = 0
      pos(tail) = (x, y)
      f(x)(y) = 0
      tail += 1
      var steps = 0
      while (tail > head) {
        val tmp = tail
        steps += 1
        while (head < tmp) {
          val (a, b) = pos(head)
          head += 1
          var x = 1
          while (x <= k) {
            val ns = circle(a, b, x)

            ns.foreach {
              case (c, d) =>
                if (c >= 0 && c < n && d >= 0 && d < m && grid(c)(d) == 0 && (f(c)(d) == -1 || f(c)(d) > steps)) {
                  f(c)(d) = steps
                  pos(tail) = c -> d
                  tail += 1
                }
            }

            x += 1
          }

        }
      }
    }


    val f1 = Array.fill(n, m)(-1)
    val f2 = Array.fill(n, m)(-1)

    bfs(0, 0, k1, f1)
    bfs(0, m - 1, k2, f2)
    var ans = Int.MaxValue
    i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        if (f1(i)(j) >= 0 && f2(i)(j) >= 0) {
          val tmp = f1(i)(j) max f2(i)(j)
          if (tmp < ans) {
            ans = tmp
          }
        }
        j += 1
      }

      i += 1
    }

    if (ans < Int.MaxValue) {
      println(ans)
    } else {
      println(-1)
    }
  }
}
