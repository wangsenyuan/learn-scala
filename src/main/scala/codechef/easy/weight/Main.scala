package codechef.easy.weight

import scala.io.StdIn

object Main {

  val MOD = 1000007

  def main(args: Array[String]): Unit = {
    val a = Array.fill(21, 201, 10)(0L)

    (1 to 9) foreach {
      i => a(1)(0)(i) = 1
    }

    for {
      n <- 2 until 21
      w <- 0 until 172
      i <- 0 until 10
      j <- 0 until 10
    } {
      val x = w + (i - j).abs
      a(n)(x)(i) += a(n - 1)(w)(j)
      if (a(n)(x)(i) >= MOD) {
        a(n)(x)(i) -= MOD
      }
    }

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val w = line(1)
        val ans = (0 until 10).foldLeft(0L) {
          (ans, i) =>
            val tmp = ans + a(n)(w)(i)
            if (tmp > MOD) {
              tmp - MOD
            } else {
              tmp
            }
        }
        println(ans)
    }
  }
}
