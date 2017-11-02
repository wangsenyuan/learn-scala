package codechef.easy.chefdice

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
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    val canNot = Array.fill(7, 7)(false)
    var valid = true
    var i = 0
    while (i < n - 1) {
      val a = nums(i)
      val b = nums(i + 1)
      if (a == b) {
        valid = false
      }
      canNot(a)(b) = true
      canNot(b)(a) = true
      canNot(a)(a) = true
      canNot(b)(b) = true
      i += 1
    }

    if (valid) {

      def findAnswer(): (Int, Int, Int, Int, Int, Int) = {
        var a = 1
        while (a <= 6) {
          var b = 1
          while (b <= 6) {
            if (a != b) {
              var c = 1
              while (c <= 6) {
                if (a != c && b != c) {
                  var d = 1
                  while (d <= 6) {
                    if (a != d && b != d && c != d && !canNot(a)(d)) {
                      var e = 1
                      while (e <= 6) {
                        if (a != e && b != e && c != e && d != e && !canNot(b)(e)) {
                          val f = 21 - a - b - c - d - e
                          if (!canNot(c)(f)) {
                            return (a, b, c, d, e, f)
                          }
                        }
                        e += 1
                      }
                    }
                    d += 1
                  }
                }
                c += 1
              }
            }

            b += 1
          }

          a += 1
        }

        return null
      }

      val ans = findAnswer()
      if (ans == null) {
        println(-1)
      } else {
        val (a, b, c, d, e, f) = ans
        val map = Map(a -> d, d -> a, b -> e, e -> b, c -> f, f -> c)
        println(s"${map(1)} ${map(2)} ${map(3)} ${map(4)} ${map(5)} ${map(6)}")
      }
    } else {
      println(-1)
    }
  }
}
