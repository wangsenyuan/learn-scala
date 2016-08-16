package codechef.numgame2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/16/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()
      if (playNim(n)) {
        println("BOB")
      } else {
        println("ALICE")
      }
      t -= 1
    }
  }

  def playNim(n: Int): Boolean = {
    n % 4 != 1
  }

}
