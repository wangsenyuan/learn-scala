package codechef.easy.chefhack

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/5.
  */
object Main {

  val N = 10000001

  def solve(primes: Array[Int]) = {
    val n = StdIn.readInt()
    val server = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      server(i) = StdIn.readLine().split("\\s+").map(_.toInt)
      i += 1
    }

    def gridHack(x: Int, y: Int, even: Boolean): Unit = {
      if (x >= 0 && x < n && y >= 0 && y < n && server(x)(y) >= 0 && primes(server(x)(y)) == 0) {
        if (even == (server(x)(y) % 2 == 0)) {
          server(x)(y) = -1
          gridHack(x - 1, y, even)
          gridHack(x + 1, y, even)
          gridHack(x, y - 1, even)
          gridHack(x, y + 1, even)
        }
      }
    }

    var res = 0L
    i = 0
    while (i < n) {
      var j = 0
      while (j < n) {
        val x = server(i)(j)
        if (x >= 0) {
          if (primes(x) >= 1) {
            res += primes(x) - 1
          } else if (x % 2 == 0) {
            res += x / 2
            gridHack(i, j, true)
          } else {
            res += (x + 1) / 2 + 1
            gridHack(i, j, false)
          }
        }
        j += 1
      }
      i += 1
    }

    println(res)
  }

  def main(args: Array[String]): Unit = {

    val primes = Array.fill(N)(1)
    primes(0) = 0
    primes(1) = 0

    var px = 1

    var x = 2
    while (x < N) {
      if (primes(x) == 1) {
        primes(x) = px
        px += 1
        var y = 2 * x
        while (y < N) {
          primes(y) = 0
          y += x
        }
      }
      x += 1
    }

    val t = StdIn.readInt()
    (0 until t) foreach {
      _ =>
        solve(primes)
    }
  }
}
