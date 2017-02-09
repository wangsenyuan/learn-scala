package codechef.easy.cheflr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/02/2017.
  */
object Main {

  val mod = 1000000007

  def findLabel(s: String) = {
    var pw = 1
    var ret = 0L
    var i = 0

    while (i < s.length) {
      if (i % 2 == s.length % 2) {
        ret = (ret + pw) % mod
      }

      if (s(s.length - i - 1) == 'r') {
        ret = (ret + pw) % mod
      }
      pw = (pw + pw) % mod
      i += 1
    }
    ret += 1

    if (s.length % 2 == 1) {
      (ret * 2) % mod
    } else {
      (2L * ret - 1L + mod) % mod
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val s = StdIn.readLine()
      val r = findLabel(s)
      println(r)
      t -= 1
    }
  }
}
