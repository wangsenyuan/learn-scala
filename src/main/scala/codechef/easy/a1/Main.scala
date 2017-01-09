package codechef.easy.a1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val m = line(1)

      var notes = Vector.empty[Int]

      var i = 0
      while (i < n) {
        i += 1
        notes :+= StdIn.readInt()
      }

      val res = canMug(m, notes)
      if (res) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }

  def canMug(m: Int, notes: Vector[Int]): Boolean = {
    val sorted = notes.sorted

    def go(got: Int, left: Vector[Int]): Boolean = {
      if (got == m) {
        true
      } else if (got > m) {
        false
      } else left match {
        case Vector() => false
        case x +: _ if x > (m - got) => false
        case x +: tail =>
          go(got, tail) || go(got + x, tail)
      }
    }

    go(0, sorted)
  }
}
