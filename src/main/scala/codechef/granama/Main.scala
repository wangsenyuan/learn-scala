package codechef.granama

import scala.io.StdIn

/**
  * Created by wangsenyuan on 05/01/2017.
  */
object Main {

  def checkAnswer(a: String, b: String): Boolean = {
    a.sorted == b.sorted || a.toSet != b.toSet
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+")
      if (checkAnswer(line(0), line(1))) {
        println("YES")
      } else {
        println("NO")
      }
      t -= 1
    }
  }
}
