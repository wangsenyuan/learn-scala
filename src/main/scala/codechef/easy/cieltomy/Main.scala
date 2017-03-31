package codechef.easy.cieltomy

import scala.io.StdIn

/**
  * Created by wangsenyuan on 31/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)
    val graph = Array.fill(n, n)(-1)

    var i = 0
    while (i < m) {
      val road = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = road(0) - 1
      val b = road(1) - 1
      val c = road(2)
      graph(a)(b) = c
      graph(b)(a) = c
      i += 1
    }

    val visited = Array.fill(n)(false)

    var best = Int.MaxValue
    var cnt = 0

    def dfs(v: Int, cur: Int): Unit = {
      if (cur <= best) {
        if (v == n - 1) {
          if (cur < best) {
            best = cur
            cnt = 1
          } else {
            cnt += 1
          }
        } else {
          visited(v) = true
          var w = 0
          while (w < n) {
            if (graph(v)(w) > 0 && !visited(w)) {
              dfs(w, cur + graph(v)(w))
            }
            w += 1
          }
          visited(v) = false
        }
      }
    }

    dfs(0, 0)

    println(cnt)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
