package codechef.kprime

import scala.io.StdIn

/**
  * Created by wangsenyuan on 06/01/2017.
  */
object Main {


  val MAX = 1000001


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    val sieve = Array.fill(MAX)(0)

    var i = 2
    while (i < MAX) {
      if (sieve(i) == 0) {
        var j = i
        while (j < MAX) {
          sieve(j) += 1
          j += i
        }
      }
      i += 1
    }

    val sum = Array.fill(6)(0)
    val total = Array.fill(6, MAX)(0)
    for {
      i <- 0 until MAX

    } {
      if (sieve(i) > 0 && sieve(i) < 6) {
        sum(sieve(i)) += 1
      }
      for {
        j <- 1 until 6
      } {
        total(j)(i) = sum(j)
      }
    }


    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val a = line(0)
      val b = line(1)
      val k = line(2)

      val ans = total(k)(b) - total(k)(a - 1)

      println(ans)

      t -= 1
    }
  }
}
