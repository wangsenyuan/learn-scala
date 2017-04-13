package codechef.easy.bwcell

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/04/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ =>
        val str = StdIn.readLine()
        val n = str.length
        val w = str.indexOf('W')
        val x = w
        val y = n - 1 - w
        if (x == y) {
          println("Chef")
        } else {
          println("Aleksa")
        }
    }
  }
}
