package codechef.easy.snck04

import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/04/2017.
  */
object Main {

  val N = 1000000


  def main(args: Array[String]): Unit = {

    val a = Array.fill(N + 1)(true)
    val b = (0 to N).toArray.map(_.toLong)
    b(0) = 0
    b(1) = 0

    var x = 2
    while (x <= N) {
      if (a(x)) {
        b(x) = x - 1
        var y = 2 * x
        while (y <= N) {
          b(y) = b(y) * (x - 1) / x
          a(y) = false
          y += x
        }
      }

      x += 1
    }

    x = 3
    while (x <= N) {
      b(x) += b(x - 1)
      x += 1
    }

    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      val n = StdIn.readInt()
      println(b(n))
      i += 1
    }
  }
}
