package codejam.year2016.roundw.b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/14/16.
  */
object Small extends App {


  private def init(n: Int): Array[Int] = {
    val array = Array.fill(n)(0)

    for {
      i <- 0 until n
    } {
      array(i) = i + 1
    }

    array
  }

  def play(d: Int, k: Int, n: Int): (Int, Int) = {
    val dancers = init(d);

    def danceOdd(j: Int): Unit =
      if (j < n) {
        var i = 0
        while (i < d) {
          val tmp = dancers(i)
          dancers(i) = dancers(i + 1)
          dancers(i + 1) = tmp
          i += 2
        }
        danceEven(j + 1)
      }

    def danceEven(j: Int): Unit =
      if (j < n) {
        var i = 0
        while (i < d) {
          val k = (i + 2) % d
          val tmp = dancers(i + 1)
          dancers(i + 1) = dancers(k)
          dancers(k) = tmp
          i += 2
        }
        danceOdd(j + 1)
      }

    danceOdd(0)

    val at = dancers.indexOf(k)
    val prev = if (at > 0) {
      dancers(at - 1)
    } else {
      dancers(d - 1)
    }

    val next = if (at == d - 1) {
      dancers(0)
    } else {
      dancers(at + 1)
    }

    (prev, next)
  }

  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val d = line(0)
    val k = line(1)
    val n = line(2)
    val (prev, next) = play(d, k, n % d)
    println(s"Case #$i: $next $prev")
  }
}
