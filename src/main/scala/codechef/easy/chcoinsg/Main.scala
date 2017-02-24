package codechef.easy.chcoinsg

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        if(n % 6 == 0) {
          println("Misha")
        } else {
          println("Chef")
        }
    }
  }
}
