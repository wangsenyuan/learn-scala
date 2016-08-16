package codechef.bestbox

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/15/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val p = line(0)
      val s = line(1)
      val v = solve(p, s)
      println(f"$v%.2f")
      t -= 1
    }
  }

  def solve(p: Double, s: Double): Double = {
    val c = s / 6;
    val b = -p / 6;
    val x = math.sqrt((b * b - 4 * c))
    val first = ((p / 6) + x) / 2
    val second = ((p / 6) - x) / 2

    if ((6 * first) < (p / 2)) {
      var a = (p / 4 - first);
      a = first * first * a;
      (s * first / 2) - a;
    } else {
      var a = (p / 4 - second);
      a = second * second * a;
      (s * second / 2) - a;
    }
  }

}
