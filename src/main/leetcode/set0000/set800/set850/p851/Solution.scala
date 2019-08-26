package set0000.set800.set850.p851

import scala.collection.mutable.ArrayBuffer

object Solution {
  def loudAndRich(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val n = quiet.length
    val outs = Array.ofDim[ArrayBuffer[Int]](n)
    val deg = Array.ofDim[Int](n)
    (0 until n).foreach(i => outs(i) = ArrayBuffer.empty[Int])

    richer.foreach(item => {
      val x = item(0)
      val y = item(1)
      outs(x) += y
      deg(y) += 1
    })

    val ans = Array.fill(n)(-1)
    var done = false

    while (!done) {
      var i = 0
      while (i < n && deg(i) != 0) {
        i += 1
      }
      done = i == n
      if (i < n) {
        deg(i) -= 1
        if (ans(i) < 0 || quiet(ans(i)) > quiet(i)) {
          // no richer one than i
          ans(i) = i
        }

        for {
          j <- outs(i)
        } {
          deg(j) -= 1
          if (ans(j) < 0 || quiet(ans(j)) > quiet(ans(i))) {
            ans(j) = ans(i)
          }
        }
      }
    }
    ans
  }
}
