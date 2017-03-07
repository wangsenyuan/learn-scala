package codechef.easy.righttri

import scala.io.StdIn

/**
  * Created by wangsenyuan on 07/03/2017.
  */
object Main {

  def rightTriangle(h: Long, s: Long): Option[(Double, Double, Double)] = {
    val x = h * h - 4 * s
    if (x < 0) {
      None
    } else {
      val y = h * h + 4 * s
      val sy = math.sqrt(y)
      val sx = math.sqrt(x)

      val a = 0.5d * (sy - sx)
      val b = 0.5d * (sy + sx)
      Some(a, b, h.toDouble)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toLong)
        val h = line(0)
        val s = line(1)

        val res = rightTriangle(h, s)
        res match {
          case None => println(-1)
          case Some((a, b, c)) => println(f"$a%.6f $b%.6f $c%.6f")
        }
    }
  }
}
