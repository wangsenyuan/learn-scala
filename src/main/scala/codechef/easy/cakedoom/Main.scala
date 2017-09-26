package codechef.easy.cakedoom

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
    val k = StdIn.readInt()
    val str = StdIn.readLine()
    val n = str.length

    def check1(): Option[String] = {
      if (n > 1) {
        None
      } else if (str(0) == '?' || str(0) == '0') {
        Some("0")
      } else {
        None
      }
    }

    def validateSeed(seed: String): Option[String] = {
      val tmp = seed * (n / 2)

      val tmp2 = tmp.zip(str)
      val valid = tmp2.forall {
        case (a, b) => a == b || b == '?'
      }
      if (valid) {
        Some(tmp)
      } else {
        None
      }
    }

    def check2(): Option[String] = {
      if (n % 2 == 0) {
        validateSeed("01").orElse(validateSeed("10"))
      } else {
        None
      }
    }

    def check3(): Option[String] = {
      val tmp = str.toCharArray

      def fix(prev: Int, i: Int, next: Int): Char = {
        if (tmp(i) == '?') {
          if (tmp(prev) != '0' && tmp(next) != '0') {
            '0'
          } else if (tmp(prev) != '1' && tmp(next) != '1') {
            '1'
          } else {
            '2'
          }
        } else {
          tmp(i)
        }
      }

      var valid = true
      var i = 1
      while (i < n && valid) {
        if (tmp(i) == tmp(i - 1) && tmp(i) != '?') {
          valid = false
        }
        i += 1
      }

      valid = valid && (tmp(n - 1) != tmp(0) || tmp(0) == '?')
      if (valid) {
        fix(n - 1, 0, 1)
        i = 1
        while (i < n - 1) {
          if (tmp(i) == '?') {
            tmp(i) = fix(i - 1, i, i + 1)
          } else {
            var prev = i - 1
            if (prev < 0) {
              prev = n - 1
            }
          }
          i += 1
        }
        fix(n - 2, n - 1, 0)
        Some(tmp.mkString(""))
      } else {
        None
      }
    }


    def check(): Option[String] = {
      if (n == 1) {
        if (str(0) == '?') {
          Some("0")
        } else if (str(0) < k + '0') {
          Some(str)
        } else {
          None
        }
      } else if (k == 1) {
        check1()
      } else if (k == 2) {
        check2()
      } else {
        check3()
      }
    }


    val valid = check()
    valid match {
      case Some(ans) => println(ans)
      case None => println("NO")
    }
  }
}
