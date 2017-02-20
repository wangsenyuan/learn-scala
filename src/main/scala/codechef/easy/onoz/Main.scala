package codechef.easy.onoz

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/02/2017.
  */
object Main {

  private def iterate(x: Int): Seq[Seq[Int]] = {
    var seq = Seq[Seq[Int]]()

    seq :+= Seq(0)
    var i = 1
    while (i < 10 && i < x) {
      var ys = Seq[Int]()
      var j = i
      while (j < x) {
        ys :+= j
        j = j * 10 + j
      }
      seq :+= ys
      i += 1
    }

    seq
  }

  def calculate(h: Int, m: Int): Int = {
    val a = iterate(h)
    val b = iterate(m)

    a.zip(b).foldLeft(0) {
      case (r, (x, y)) =>
        r + (x.size * y.size)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val h = line(0)
      val m = line(1)

      val r = calculate(h, m)

      println(r)

      t -= 1
    }
  }
}
