package codechef.easy.drghts

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val labels = StdIn.readLine().split("\\s+").map(_.toInt)

    val neighbors = Array.fill[ListBuffer[Int]](n)(null)

    var i = 0
    while (i < m) {
      val edge = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      val a = edge(0)
      val b = edge(1)
      if (neighbors(a) == null) {
        neighbors(a) = ListBuffer.empty[Int]
      }
      neighbors(a) += b

      if (neighbors(b) == null) {
        neighbors(b) = ListBuffer.empty[Int]
      }
      neighbors(b) += a
      i += 1
    }

    val graph = neighbors.map(lst => if (lst == null) Array() else lst.toArray)

    val is = Array.fill(n)(-1)
    val ps = Array.fill(n)(-1)
    val rs = Array.fill(n)(-1)
    val visited = Array.fill(n)(false)

    def dfs(v: Int, root: Int): Unit = {
      rs(v) = root
      is(v) = labels(v)
      visited(v) = true
      graph(v).foreach {
        w =>
          if (!visited(w)) {
            dfs(w, root)
            is(v) += is(w)
            ps(w) = v
          }
      }
    }

    def rubik(root: Int): Int = {
      val xs = (0 until n).filter(x => rs(x) == root)
      var ans = 0
      xs.foreach {
        x =>
          if (is(root) > is(x) && is(x) > 0) {
            ans += 1
          } else if (labels(x) == 1 && is(x) > 1) {
            ans += 1
          } else if (xs.filter(y => ps(y) == x && is(y) > 0).size > 1) {
            ans += 1
          }
      }
      ans
    }

    var ans1 = 0L
    var ans2 = 0
    (0 until n) foreach {
      x =>
        if (!visited(x)) {
          dfs(x, x)
          ans1 += 1L * is(x) * (is(x) - 1) / 2
          ans2 += rubik(x)
        }
    }
    println(s"$ans1 $ans2")

  }
}
