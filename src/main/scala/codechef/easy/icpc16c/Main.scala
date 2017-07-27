package codechef.easy.icpc16c

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      val d = StdIn.readInt()
      val a = d % 9
      println(a + 1)
      i += 1
    }
  }
}
