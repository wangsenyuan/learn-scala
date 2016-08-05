package codechef.ceilab

import scala.io.StdIn

/**
  * Created by wangsenyuan on 7/27/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine.split("\\s+").map(_.toInt)
    val a = line(0)
    val b = line(1)
    val c =
      if (a > b) {
        a - b
      } else {
        b - a
      }

    var d = c % 10;
    val e = c / 10;

    if (d > 1) {
      d -= 1;
    } else {
      d += 1;
    }

    val f = e * 10 + d;
    println(f);
  }
}
