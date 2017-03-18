package codechef.easy.pairsum

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val x = StdIn.readLine().split("\\s+").map(_.toInt).sorted

    val cache = mutable.Map[Int, Int]()

    var ans = 0
    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n) {
        val s = x(i) + x(j)
        if (cache.contains(s)) {
          cache += s -> (cache(s) + 1)
        } else {
          cache += s -> 1
        }
        if (ans < cache(s)) {
          ans = cache(s)
        }
        j += 1
      }

      i += 1
    }


    println(2 * ans)
  }
}
