package codechef.easy.chmod

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/03/2017.
  */
object Main {


  def preCompute(): Array[Int] = {
    val n = 100
    var res = Vector.empty[Int]
    val set = new util.BitSet()
    var x = 2
    while (x <= n) {
      x = set.nextClearBit(x)

      res :+= x
      var y = x
      while (y <= n) {
        set.set(y)
        y += x
      }
      x += 1
    }

    res.toArray
  }

  def fastSquare(x: Int, r: Int, mod: Long): Long = {
    if (r == 0) {
      1 % mod
    } else {
      val y = fastSquare(x, r / 2, mod)
      val z = (y * y) % mod
      if (r % 2 == 1) {
        (z * x) % mod
      } else {
        z
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val ps = preCompute()

    val as = Array.fill(101, ps.length)(0)

    var a = 1
    while (a <= 100) {
      var j = 0
      while (j < ps.length) {
        var x = a

        var cnt = 0
        while (x % ps(j) == 0) {
          cnt += 1
          x /= ps(j)
        }

        as(a)(j) = cnt

        j += 1
      }

      a += 1
    }


    val n = StdIn.readInt()

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    val cf = Array.fill(n, ps.length)(0)

    var i = 0
    while (i < n) {
      val x = nums(i)
      var j = 0
      while (j < ps.length) {
        cf(i)(j) = as(x)(j)
        if (i > 0) {
          cf(i)(j) += cf(i - 1)(j)
        }
        j += 1
      }

      i += 1
    }

    val m = StdIn.readInt()
    i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+")
      val left = line(0).toInt - 1
      val right = line(1).toInt - 1
      val mod = line(2).toLong

      var ans = 1L

      var j = 0
      while (j < ps.length) {
        val r =
          if (left > 0) {
            cf(right)(j) - cf(left - 1)(j)
          } else {
            cf(right)(j)
          }
        val v = fastSquare(ps(j), r, mod)
        ans = (ans * v) % mod
        j += 1
      }

      println(ans)

      i += 1
    }
  }
}
