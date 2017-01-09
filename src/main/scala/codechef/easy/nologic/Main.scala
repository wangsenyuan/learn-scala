package codechef.easy.nologic

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val letters = ('a' to 'z').toArray

    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val line = StdIn.readLine()
      val words = line.toLowerCase().toSet
      val ans = letters.filterNot(words)
      if (ans.isEmpty) {
        println("~")
      } else {
        println(ans.mkString(""))
      }
    }
  }
}
