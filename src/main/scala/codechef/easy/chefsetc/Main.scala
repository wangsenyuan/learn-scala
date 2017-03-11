package codechef.easy.chefsetc

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/11.
  */
object Main {

  def one(a: Int, b: Int, c: Int, d: Int): Boolean = {
    a == 0 || b == 0 || c == 0 || d == 0
  }

  def two(a: Int, b: Int, c: Int, d: Int): Boolean = {
    a + b == 0 || b + c == 0 || c + d == 0 || a + c == 0 || a + d == 0 || b + d == 0
  }

  def three(a: Int, b: Int, c: Int, d: Int): Boolean = {
    val sum = a + b + c + d
    a == sum || b == sum || c == sum || d == sum
  }

  def four(a: Int, b: Int, c: Int, d: Int): Boolean = {
    a + b + c + d == 0
  }

  def check(a: Int, b: Int, c: Int, d: Int): Boolean = {
    val fs = Vector(one _, two _, three _, four _)
    fs.exists(_ (a, b, c, d))
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)

        val a = line(0)
        val b = line(1)
        val c = line(2)
        val d = line(3)

        if (check(a, b, c, d)) {
          println("Yes")
        } else {
          println("No")
        }
    }
  }
}
