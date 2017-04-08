package codechef.easy.chefseg

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/04/2017.
  */
object Main {

  private def findRange(k: Long): (Double, Double) = {
    if (k == 1) {
      (0.0, 1.0)
    } else {
      val (a, b) = findRange(k >> 1)
      val mid = (a + b) / 2.0
      if ((k & 1) == 1) {
        //right
        (mid, b)
      } else {
        (a, mid)
      }
    }
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val x = line(0).toInt
    val k = line(1).toLong
    val (a, b) = findRange(k)
    val c = (a + b) / 2.0
    val res = c * x

    println(f"$res%.7f")
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
