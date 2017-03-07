package codechef.easy.twodogs

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 07/03/2017.
  */
object Main {

  def pickApples(apples: Array[Int], n: Int, k: Int) = {
    val left = new mutable.HashMap[Int, Int]()
    val right = new mutable.HashMap[Int, Int]()

    var i = 0
    while (i < n) {
      val x = apples(i)

      if (!left.contains(x)) {
        left += (x -> i)
      }

      right += (x -> i)

      i += 1
    }

    var best = 2 * n
    i = 0
    while (i < n) {
      val x = apples(i)
      val y = k - x
      if (x < k && x != y && y > 0 && left.contains(y)) {
        val d = (i + 1) min (n - i)

        val a = left(y)
        val b = right(y)
        val c = ((a + 1) min (n - b)) max d
        best = best min c
      }

      i += 1
    }
    if (best == 2 * n) {
      -1
    } else {
      best
    }
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)

    val apples = StdIn.readLine().split("\\s+").map(_.toInt)

    val res = pickApples(apples, n, k)

    println(res)
  }
}
