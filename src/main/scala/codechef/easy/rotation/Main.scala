package codechef.easy.rotation

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)

    val n = line(0)
    var m = line(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    var shift = 0

    while (m > 0) {
      val query = StdIn.readLine().split("\\s+")
      val tp = query(0)
      val d = query(1).toInt

      tp match {
        case "R" =>
          val i = (d - 1 - shift + n) % n
          println(nums(i))
        case "A" =>
          shift = (shift + d) % n
        case "C" =>
          shift = (shift + n - d) % n
      }

      shift = (shift + n) % n

      m -= 1
    }
  }
}
