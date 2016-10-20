package codejam.year2016.round3.b

import scala.io.StdIn
import scala.util.Random

/**
  * Created by wangsenyuan on 18/10/2016.
  */
object Small extends App {

  val rand = new Random(41)

  private def merge(a: String, b: String): String = {
    def go(i: Int, j: Int, c: String): String = {
      if (i + j == 0) {
        c
      } else {
        val k = rand.nextInt(i + j)
        if (k < i) {
          go(i - 1, j, c + a(a.length - i))
        } else {
          go(i, j - 1, c + b(b.length - j))
        }
      }
    }
    go(a.length, b.length, "")
  }

  def sample(str: String, g: Array[Vector[Int]]): String = {
    def go(v: Int, checked: Set[Int]): String = {
      str(v) + g(v).filterNot(checked).foldLeft("") {
        (res, w) => merge(res, go(w, checked + v))
      }
    }

    go(0, Set.empty)
  }

  def repeat(n: Int, f: Int => Unit): Unit = {
    var i = 0
    while (i < n) {
      f(i)
      i += 1
    }
  }

  val T = StdIn.readInt
  var t = 1

  while (t <= T) {
    print(s"Case #$t:")

    val n = StdIn.readInt()

    val graph = Array.fill(n + 1)(Vector.empty[Int])

    val line = StdIn.readLine().split("\\s+").map(_.toInt)

    for {
      i <- 1 to n
      x = line(i - 1)
    } {
      if (graph(x).isEmpty) {
        graph(x) = Vector(i)
      } else {
        graph(x) = graph(x) :+ i
      }
    }

    val str = " " + StdIn.readLine()

    StdIn.readLine()

    val xs = StdIn.readLine().split("\\s+")
    val cnt = Array.fill(xs.length)(0)

    repeat(10000, _ => {
      val r = sample(str, graph)
      for {
        i <- 0 until xs.length
        x = xs(i)
        if r.contains(x)
      } {
        cnt(i) += 1
      }
    })

    for {
      x <- cnt
      p = 1.0d * x / 10000
    } {
      print(f" $p%.3f")
    }

    println()
    t += 1
  }


}
