package codechef.easy.cleanup

import scala.io.StdIn

/**
  * Created by wangsenyuan on 7/27/16.
  */
object Main {

  def output(a: Vector[Int]) =
    if (a.isEmpty) {
      println()
    } else {
      println(a.mkString(" "))
    }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val m = line(1)
      val line2 = StdIn.readLine().split("\\s+").filter(_.length > 0).map(_.toInt)
      val finished = line2.toSet
      val (a, b) = play(n, finished)

      output(a)
      output(b)

      t -= 1
    }
  }

  def play(n: Int, finished: Set[Int]): (Vector[Int], Vector[Int]) = {
    def chef(i: Int, a: Vector[Int], b: Vector[Int]): (Vector[Int], Vector[Int]) = {
      if (i > n) {
        (a, b)
      } else if (finished.contains(i)) {
        chef(i + 1, a, b)
      } else {
        assistant(i + 1, a :+ i, b)
      }
    }

    def assistant(i: Int, a: Vector[Int], b: Vector[Int]): (Vector[Int], Vector[Int]) = {
      if (i > n) {
        (a, b)
      } else if (finished.contains(i)) {
        assistant(i + 1, a, b)
      } else {
        chef(i + 1, a, b :+ i)
      }
    }

    chef(1, Vector.empty, Vector.empty)
  }
}
