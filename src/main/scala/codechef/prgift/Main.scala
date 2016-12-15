package codechef.prgift

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val k = firstLine(1)
      val gifts = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = canGive(gifts, k)
      if (res) {
        println("YES")
      } else {
        println("NO")
      }
    }
  }

  def canGive(gifts: Array[Int], k: Int): Boolean = {

    gifts.filter(_ % 2 == 0).length >= k

  }
}
