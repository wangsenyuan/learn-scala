package codechef.easy.kingship

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val ps = StdIn.readLine().split("\\s+").map(_.toInt)

      var minIdx = -1
      var i = 0
      while (i < ps.length) {

        if (minIdx == -1 || ps(i) < ps(minIdx)) {
          minIdx = i
        }

        i += 1
      }

      i = 0
      var res = 0L
      while (i < ps.length) {

        res += (if (i != minIdx) 1L * ps(i) * ps(minIdx) else 0L)

        i += 1
      }

      println(res)
    }
  }
}
