package codechef.easy.reverse

import scala.io.StdIn

/**
  * Created by wangsenyuan on 23/02/2017.
  */
object Main {
  val INF = 1000000000

  def reverse(in: Array[Seq[Int]], out: Array[Seq[Int]], n: Int) = {
    val ds = Array.fill(n)(INF)

    val visited = Array.fill(n)(false)

    var que = Vector(0)
    ds(0) = 0

    while (que.size > 0) {
      val v = que.head
      que = que.tail
      if (!visited(v)) {
        visited(v) = true

        out(v) foreach {
          w =>
            if (ds(w) > ds(v)) {
              ds(w) = ds(v)
              que = w +: que
            }
        }

        in(v) foreach {
          w =>
            if (ds(w) > ds(v) + 1) {
              ds(w) = ds(v) + 1
              que = que :+ w
            }
        }
      }
    }
    ds(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var m = firstLine(1)

    val in = Array.fill(n)(Seq.empty[Int])
    val out = Array.fill(n)(Seq.empty[Int])

    while (m > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      val x = line(0)
      val y = line(1)

      out(x) = out(x) :+ y
      in(y) = in(y) :+ x

      m -= 1
    }

    val res = reverse(in, out, n)

    if (res == INF) {
      println(-1)
    } else {
      println(res)
    }
  }
}
