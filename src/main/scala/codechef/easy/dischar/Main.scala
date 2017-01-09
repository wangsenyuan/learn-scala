package codechef.easy.dischar

import scala.io.StdIn

/**
  * Created by wangsenyuan on 29/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val line = StdIn.readLine()
      val distinctChars = line.toSet
      println(distinctChars.size)
    }
  }
}
