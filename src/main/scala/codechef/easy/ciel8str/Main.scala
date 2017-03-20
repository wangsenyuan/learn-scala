package codechef.easy.ciel8str

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/18.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val s = StdIn.readLine()
    var nz = 0
    var ans = 0L
    var i = 0
    while (i < s.length) {
      val x = s(i) - '0'
      if (x % 8 == 0) {
        ans += 1
      }

      if (i > 0) {
        val y = s(i - 1) - '0'
        if (y != 0 && (y * 10 + x) % 8 == 0) {
          ans += 1
        }

        if (i > 1) {
          val z = s(i - 2) - '0'
          if (z != 0) {
            nz += 1
          }
          if ((z * 100 + y * 10 + x) % 8 == 0) {
            ans += nz
          }
        }
      }

      i += 1
    }
    println(ans)
  }

  /*def main1(args: Array[String]): Unit = {
    val s = StdIn.readLine()
    val n = s.length
    val dp = Array.fill(n, 8)(0)

    dp(0)((s(0) - '0') % 8) = 1
    var i = 1
    while (i < n) {
      var aft = 0
      while (aft < 8) {

      }
    }
  }*/
}
