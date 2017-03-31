package codechef.easy.devstr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 31/03/2017.
  */
object Main {


  def caseOne(org: String, str: String, n: Int) = {
    val xs = str * (n / 2)
    val ys = if (n % 2 == 1) {
      xs + str(0)
    } else {
      xs
    }

    val cnt = ys.zip(org).count(y => y._1 != y._2)
    (ys, cnt)
  }

  def caseOther(str: String, n: Int, k: Int): (String, Int) = {
    val res = str.toCharArray.map(_ - '0')
    var cnt = 0
    var j = 0
    var i = 1
    while (i <= n) {
      if (i == n || str(i) != str(i - 1)) {
        val m = i - j
        if (m > k) {
          var a = j + k
          while (a < i) {
            if (a == i - 1) {
              a -= 1
            }
            res(a) = 1 - res(a)
            cnt += 1
            a += k + 1
          }
        }

        j = i
      }

      i += 1
    }

    (res.mkString(""), cnt)
  }

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)

    val n = firstLine(0)
    val k = firstLine(1)

    val str = StdIn.readLine()

    if (k == 1) {
      val (x, xc) = caseOne(str, "01", n)
      val (y, yc) = caseOne(str, "10", n)
      if (xc < yc) {
        println(xc)
        println(x)
      } else {
        println(yc)
        println(y)
      }
    } else {
      val (res, cnt) = caseOther(str, n, k)
      println(cnt)
      println(res)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
