package codejam.year2016.round3.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/12/16.
  */
object App extends App {

  def play(j: Int, p: Int, s: Int, k: Int): List[(Int, Int, Int)] = {
    var result: List[(Int, Int, Int)] = Nil

    val z = k min s
    var x = 1
    while (x <= j) {
      var m = x
      var y = 0
      while (y < z * p) {
        result = (x, y / z + 1, m) :: result
        m = if (m == s) {
          1
        } else {
          m + 1
        }
        y += 1
      }
      x += 1
    }

    result
  }

  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val j = line(0)
    val p = line(1)
    val s = line(2)
    val k = line(3)
    println(s"Case #$i: ${j * p * (s min k)}\n")
    val result = play(j, p, s, k)
    result.foreach {
      p =>
        val (a, b, c) = p
        println(s"$a $b $c")
    }
  }
}
