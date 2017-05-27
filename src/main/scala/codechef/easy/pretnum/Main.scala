package codechef.easy.pretnum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 26/05/2017.
  */
object Main {

  val N = 1000010

  def sieve(): Array[Boolean] = {
    val primes = Array.fill(N + 1)(true)

    primes(0) = false
    primes(1) = false

    var i = 2
    while (i <= N) {
      if (primes(i)) {
        var j = i * 2
        while (j <= N) {
          primes(j) = false
          j += i
        }
      }

      i += 1
    }

    primes
  }

  def solve(primes: Array[Boolean]) = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val l = line(0)
    val r = line(1)

    val rem = Array.fill((r - l + 1).toInt)(0L)
    val cnt = Array.fill((r - l + 1).toInt)(1)
    var i = l
    while (i <= r) {
      rem((i - l).toInt) = i
      i += 1
    }

    var x = 2
    while (x < N) {
      if (primes(x)) {
        var y = ((l - 1) / x + 1) * x
        while (y <= r) {
          val i = (y - l).toInt
          var c = 0
          while (rem(i) % x == 0) {
            rem(i) /= x
            c += 1
          }
          cnt(i) *= c + 1

          y += x
        }
      }

      x += 1
    }

    var ans = 0L
    i = 0
    while (i <= r - l) {
      if (rem(i.toInt) > 1) {
        cnt(i.toInt) *= 2
      }

      if (primes(cnt(i.toInt))) {
        ans += 1
      }

      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val primes = sieve()

    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve(primes)
    }
  }
}
