package codechef.easy.tuzgmbr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/05/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val m = line(1)
        val grudyNumber = ((n - 1) % 4) ^ ((m - 1) % 3)
        if (grudyNumber == 0) {
          println("Vanya")
        } else {
          println("Tuzik")
        }
    }
  }
}
