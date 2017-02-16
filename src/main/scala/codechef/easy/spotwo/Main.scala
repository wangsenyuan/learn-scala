package codechef.easy.spotwo

import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/02/2017.
  */
object Main {

  val M = 1000000007L

  def binaryRep(n: Int): BigInt = {
    var x = n
    var y = BigInt(0)
    var base = BigInt(1)
    while (x > 0) {
      y += BigInt(x & 1) * base
      base *= 10
      x = x >> 1
    }

    y
  }

  def fastExp(x: Int, n: BigInt): Int = {
    if (n == 0) {
      1
    } else {
      val y = fastExp(x, n / 2) toLong
      val z = ((y * y) % M)
      if (n % 2 == 1) {
        ((x * z) % M).toInt
      } else {
        z toInt
      }
    }

  }

  def calculate(n: Int) = {
    val x = binaryRep(n)
    val y = fastExp(2, x)
    fastExp(y.toInt, 2)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()
      val res = calculate(n)
      println(res)
      t -= 1
    }
  }
}
