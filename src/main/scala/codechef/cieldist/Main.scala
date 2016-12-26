package codechef.cieldist

import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()

    while (n > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val ds = line(0)
      val dt = line(1)
      val d = line(2)

      val s = minDist(ds, dt, d)

      println(s)
      n -= 1
    }
  }

  def minDist(ds: Int, dt: Int, d: Int): Int = {
    if (d > ds + dt) {
      d - ds - dt
    } else if (ds > d + dt) {
      ds - d - dt
    } else if (dt > ds + d) {
      dt - d - ds
    } else {
      0
    }
  }
}
