package codechef.easy.lucky5

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()
    while (n > 0) {
      n -= 1

      val num = StdIn.readLine()
      val notLuckyNumber = num.count(p => p != '4' && p != '7')
      println(notLuckyNumber)
    }
  }
}
