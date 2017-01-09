package codechef.easy.horses

import scala.io.StdIn

/**
  * Created by wangsenyuan on 7/28/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val _ = StdIn.readInt()
      val line = StdIn.readLine().split("\\s+").map(_.toInt).sorted.toList

      val minDiff =
        line.zip(line.tail).map {
          case (a, b) => b - a
        }.min

      println(minDiff)

      t -= 1
    }
  }
}
