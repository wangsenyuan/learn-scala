package codechef.luckystr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+")
    val k = firstLine(0).toInt
    val n = firstLine(1).toInt

    val as = Array.fill(k)("")
    var i = 0
    while (i < k) {
      as(i) = StdIn.readLine()
      i += 1
    }

    i = 0
    while (i < n) {
      val str = StdIn.readLine()
      if (checkStrGood(str, as)) {
        println("Good")
      } else {
        println("Bad")
      }
      i += 1
    }
  }

  def checkStrGood(str: String, as: Array[String]): Boolean = {

    def check1(str: String) = str.length >= 47

    def check2(str: String): Boolean = {
      as.exists(a => str.contains(a))
    }

    check1(str) || check2(str)
  }
}
