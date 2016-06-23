package codejam.year2016.round3.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 6/23/16.
  */
object Small extends App {

  def maxPalindromeSubString(s: String): (Int, Int) = {
    var max = 0
    var at = 0
    var i = 0
    while (i < s.length) {
      var j = i
      var k = i + 1
      while (j >= 0 && k < s.length && s(j) == s(k)) {
        j -= 1
        k += 1
      }
      val len = (k - 1 - (j + 1) + 1)
      if (len > max) {
        at = j + 1
        max = len
      }
      i += 1
    }

    return (at, max)
  }

  def play(s: String): Int = {
    def go(s: String, score: Int): Int = {
      val (at, mps) = maxPalindromeSubString(s)
      if (mps > 0) {
        val x = s.substring(0, at) + s.substring(at + mps)
        go(x, score + 5 * mps)
      } else {
        score + 5 * s.length / 2
      }
    }

    return go(s, 0)
  }

  val t = StdIn.readInt()

  var i = 1
  while (i <= t) {
    val s = StdIn.readLine()
    val r = play(s)
    println(s"Case #$i: $r")
    i += 1
  }

}
