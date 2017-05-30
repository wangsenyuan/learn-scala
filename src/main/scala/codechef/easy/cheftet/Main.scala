package codechef.easy.cheftet

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/29.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val b = StdIn.readLine().split("\\s+").map(_.toLong)
    val a = StdIn.readLine().split("\\s+").map(_.toLong)

    def check(candidate: Long): Boolean = {
      var flag = true
      var i = 0
      while (i < n && flag) {
        var tmp = a(i)

        if (i > 0) {
          tmp += b(i - 1)
          b(i - 1) = 0
        }

        if (tmp < candidate) {
          if (i < n - 1 && tmp + b(i) + b(i + 1) == candidate) {
            b(i) = 0
            b(i + 1) = 0
          } else if (tmp + b(i) == candidate) {
            b(i) = 0
          } else if (i < n - 1 && tmp + b(i + 1) == candidate) {
            b(i + 1) = 0
          } else {
            flag = false
          }
        } else if (tmp > candidate) {
          flag = false
        }

        i += 1
      }

      flag && b.forall(_ == 0)
    }

    val sum = b.sum + a.sum
    if (sum % n != 0) {
      println(-1)
    } else {
      val res = sum / n
      if (check(res)) {
        println(res)
      } else {
        println(-1)
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
