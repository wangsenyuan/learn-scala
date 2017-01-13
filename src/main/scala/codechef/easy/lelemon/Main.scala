package codechef.easy.lelemon

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)
      val ps = StdIn.readLine().split("\\s+").map(_.toInt)
      val cs = Array.fill(n)(List.empty[Int])

      var i = 0
      while (i < n) {
        val vs = StdIn.readLine().split("\\s+").map(_.toInt)
        cs(i) = vs.drop(1).sorted.reverse.toList
        i += 1
      }

      var res = 0

      for {
        p <- ps
      } {
        if (!cs(p).isEmpty) {
          res += cs(p).head
          cs(p) = cs(p).tail
        }
      }

      println(res)

      t -= 1
    }
  }
}
