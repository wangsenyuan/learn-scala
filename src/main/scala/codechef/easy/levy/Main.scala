package codechef.easy.levy

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/03/2017.
  */
object Main {

  val N = 10000

  def primes(n: Int): Vector[Int] = {
    val nums = new util.BitSet()
    var x = 2
    var ps = Vector.empty[Int]
    while (x < n) {
      x = nums.nextClearBit(x);
      ps :+= x
      var y = 2 * x
      while (y < n) {
        nums.set(y)
        y += x
      }
      x += 1
    }

    ps
  }

  def count(ps: Vector[Int], N: Int) = {
    val res = Array.fill(N + 1)(0)

    for {
      x <- ps
      y <- ps
      if (x + 2 * y <= N)
    } {
      res(x + 2 * y) += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val ps = primes(N)

    val cnt = count(ps, N)

    val t = StdIn.readInt()
    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        println(cnt(n))
    }
  }
}
