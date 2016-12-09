package codejam.year2008.round1b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object AppA {

  def main(args: Array[String]): Unit = {
    val N = StdIn.readInt()

    var i = 1

    while (i <= N) {
      val line = StdIn.readLine().split("\\s+")

      val n = line(0).toInt
      val A = line(1).toLong
      val B = line(2).toLong
      val C = line(3).toLong
      val D = line(4).toLong
      val x0 = line(5).toLong
      val y0 = line(6).toLong
      val M = line(7).toLong

      val res = play(n, A, B, C, D, x0, y0, M)

      println(s"Case #$i: $res")

      i += 1
    }
  }


  def play(n: Int, A: Long, B: Long, C: Long, D: Long, x0: Long, y0: Long, M: Long): Long = {
    val bucket = Array.fill(9)(0L)

    def fillBucket(x: Long, y: Long, i: Int): Unit =
      if (i < n) {
        bucket(((x % 3) * 3 + (y % 3)).toInt) += 1
        fillBucket((A * x + B) % M, (C * y + D) % M, i + 1)
      }

    fillBucket(x0, y0, 0)

    val sameBucket = {
      for (i <- 0 until 9) yield {
        (bucket(i) * (bucket(i) - 1) * (bucket(i) - 2)) / 6
      }
    } sum

    val differentBucket = {
      for {
        i <- 0 until 9
        j <- (i + 1) until 9
        k <- (j + 1) until 9
        if ((i % 3 + j % 3 + k % 3) % 3 == 0)
        if ((i / 3 + j / 3 + k / 3) % 3 == 0)
      } yield {
        bucket(i) * bucket(j) * bucket(k)
      }
    } sum

    sameBucket + differentBucket
  }
}
