package codechef.easy.taaplusb

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/7.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val N = 100000

    var x = 0D
    val f = Array.fill(N + 1)(0D)

    var i = 1
    while (i <= N) {
      x = 0.45d * (1 - x) + 0.55d * x
      f(i) = x + f(i - 1)
      i += 1
    }

    val n = StdIn.readInt()
    (0 until n) foreach {
      _ =>
        val i = StdIn.readInt()
        println(f"${f(i)}%.6f")
    }
  }
}
