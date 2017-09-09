package codechef.easy.chefmovr

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val d = firstLine(1)
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    if (n == 1) {
      println(0)
    } else {
      var sum = 0L
      var i = 0
      while (i < n) {
        sum += nums(i)
        i += 1
      }
      if (sum % n != 0) {
        println(-1)
      } else {
        val avg = sum / n
        var ans = 0l
        var fail = false
        var i = 0
        while (i < d && !fail) {
          var tmp = 0L
          var cnt = 0
          var j = i
          while (j < n) {

            if (nums(j) < avg && j + d < n) {
              ans += avg - nums(j)
              nums(j + d) += nums(j) - avg
              nums(j) = avg
            } else if (nums(j) > avg && j + d < n) {
              ans += nums(j) - avg
              nums(j + d) += nums(j) - avg
              nums(j) = avg
            }

            tmp += nums(j)

            cnt += 1
            j += d
          }

          if (tmp != cnt * avg) {
            fail = true
          }

          i += 1
        }
        if (fail) {
          println(-1)
        } else {
          println(ans)
        }
      }
    }

  }
}
