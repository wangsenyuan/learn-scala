package codechef.capple

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/2.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val apples = StdIn.readLine().split("\\s+").map(_.toInt).sorted

      var res = 1
      var i = 1
      while (i < apples.length) {
        if (apples(i) > apples(i - 1)) {
          res += 1
        }
        i += 1
      }

      println(res)
    }
  }
}
