package codechef.easy.chefston

import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1

      val line = StdIn.readLine().split("\\s+")
      val n = line(0).toInt
      val k = line(1).toInt

      val as = StdIn.readLine().split("\\s+").map(_.toLong)
      val bs = StdIn.readLine().split("\\s+").map(_.toLong)

      val cs = as.zip(bs).map {
        case (a, b) => k / a * b
      }
      val res = cs max

      println(res)
    }
  }
}
