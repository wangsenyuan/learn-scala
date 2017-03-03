package codechef.easy.drange

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    val ds = Array.fill(1000010)(0)

    (0 until t) foreach {
      _ =>
        val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = firstLine(0)
        val m = firstLine(1)

        util.Arrays.fill(ds, 0)

        (0 until m) foreach {
          _ =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt)
            val w = line(0)
            val x = line(1)
            val y = line(2)
            val z = line(3)
            w match {
              case 1 =>
                ds(x - 1) += z
                ds(y) -= z
              case _ =>
                ds(x - 1) -= z
                ds(y) += z
            }
        }

        var cur = 0
        var a = Int.MaxValue
        var b = Int.MinValue

        (0 until n) foreach {
          i =>
            cur += ds(i)
            a = a min (cur + i + 1)
            b = b max (cur + i + 1)
        }

        println(b - a)

    }
  }

}
