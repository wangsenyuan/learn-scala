package codechef.easy.primes2

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/02/2017.
  */
object Main {

  val N = 1000000

  def sieve(n: Int) = {
    val bs = new util.BitSet()
    var ps = Vector.empty[Int]
    var i = 2
    while (i < n) {
      i = bs.nextClearBit(i)
      ps = ps :+ i
      var j = 2 * i
      while (j < n) {
        bs.set(j)
        j += i
      }
      i += 1
    }

    ps
  }

  def squareAndCube(p1: Vector[Int], n: Int) = {
    var p2 = Vector.empty[Int]
    var p3 = Vector.empty[Int]
    var i = 0
    while (i < p1.length) {
      val p = p1(i)
      if (p * p < n) {
        p2 :+= p
      }

      if (p * p * p < n) {
        p3 :+= p
      }
      i += 1
    }

    (p2, p3)
  }

  def search(len: Int, f: Int => Boolean): Int = {
    //f(-1) = false, f(len) = true
    var i = 0
    var j = len
    while (i < j) {
      val k = i + (j - i) / 2
      if (!f(k)) {
        i = k + 1
      } else {
        j = k
      }
    }
    i
  }

  def findAnswer(n: Int, p1: Vector[Int], p2: Vector[Int], p3: Vector[Int]): (Int, Int, Int) = {

    var i = 0
    while (i < p3.length && p3(i) * p3(i) * p3(i) < n) {
      val a = p3(i) * p3(i) * p3(i)

      var j = 0
      while (j < p2.length && (a + p2(j) * p2(j)) < n) {
        val b = p2(j) * p2(j)
        val c = n - a - b
        val k = search(p1.length, p1(_) >= c)
        if (k < p1.length && p1(k) == c) {
          return (p1(k), p2(j), p3(i))
        }
        j += 1
      }

      i += 1
    }

    (0, 0, 0)
  }

  def main(args: Array[String]): Unit = {

    val p1 = sieve(N)
    val (p2, p3) = squareAndCube(p1, N)

    var n = StdIn.readInt()

    while (n > 0) {
      val (a, b, c) = findAnswer(n, p1, p2, p3)
      println(s"$a $b $c")
      n = StdIn.readInt()
    }
  }
}
