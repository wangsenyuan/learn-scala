package codechef.chefa

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
      val nums = StdIn.readLine().split("\\s+").map(_.toLong).sorted.reverse

      val res = nums.zipWithIndex.filter {
        case (_, idx) => idx % 2 == 0
      }.map(_._1).sum

      println(res)
    }
  }
}
