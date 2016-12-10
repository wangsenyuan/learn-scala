package codechef.alexnumb

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt

    while (t > 0) {
      val n = StdIn.readLong()
      StdIn.readLine()

      println(n * (n - 1) / 2)

      t -= 1
    }
  }
}
