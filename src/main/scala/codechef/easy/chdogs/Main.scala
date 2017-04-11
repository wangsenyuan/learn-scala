package codechef.easy.chdogs

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/11.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val s = line(0)
        val v = line(1)
        val ans = (2.0d * s) / (3.0d * v)

        println(f"$ans%.8f")
    }
  }
}
