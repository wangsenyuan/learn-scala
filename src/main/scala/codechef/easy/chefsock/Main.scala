package codechef.easy.chefsock

import scala.io.StdIn

/**
  * Created by wangsenyuan on 23/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val jacket = line(0)
    val sock = line(1)
    val money = line(2)
    val buy = (money - jacket) / sock

    if (buy % 2 == 0) {
      println("Lucky Chef")
    } else {
      println("Unlucky Chef")
    }

  }
}
