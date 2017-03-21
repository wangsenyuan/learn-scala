package codechef.easy.divnine

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/21.
  */
object Main {

  def addOne(str: String, n: Int): Int = {
    if (n % 9 == 0) {
      0
    } else {
      //it can always add to 9 to divide 9
      ((n + 8) / 9) * 9 - n
    }
  }

  def subOne(str: String, n: Int): Int = {
    if (n % 9 == 0) {
      0
    } else {
      val m = n - (n / 9) * 9
      //can't sub the first digit to zero
      var ans = 0
      var i = 0
      while (i < str.length && ans < m) {
        val x = str(i) - '0'
        if (x > 0 && i == 0 && str.length > 1) {
          //sub to one
          ans += x - 1
        } else {
          ans += x
        }

        if (ans > m) {
          ans = m
        }

        i += 1
      }

      if (ans < m) {
        //10 is large enough to compare with addOne result
        10
      } else {
        ans
      }
    }
  }

  def solve() = {
    val n = StdIn.readLine()
    val s = n.toCharArray.map(_ - '0').sum
    val x = addOne(n, s)
    val y = subOne(n, s)
    val ans = x min y
    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve();
      i += 1
    }
  }
}
