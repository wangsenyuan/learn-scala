package codechef.easy.witmath

import scala.io.StdIn

/**
  * Created by wangsenyuan on 31/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val n = StdIn.readLong()
      var x = n
      while (!(BigInt(x).isProbablePrime(20))) {
        x -= 1
      }
      println(x)
      i += 1
    }
  }
}
