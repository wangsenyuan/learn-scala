package set0000.set900.set900.p903

import scala.collection.mutable

object Solution {

  val MOD = (1e9 + 7).toInt

  def numPermsDISequence(S: String): Int = {
    val n = S.length
    val C = Array.ofDim[Int](n + 1, n + 1)
    C(0)(0) = 1

    for {
      i <- 1 to n
    } {
      C(i)(0) = 1
      C(i)(i) = 1
      for {
        j <- 1 until i
      } {
        C(i)(j) = modAdd(C(i - 1)(j), C(i - 1)(j - 1))
      }
    }

    val dp = Array.fill(n, n)(-1)

    def dfs(i: Int, j: Int): Int = {
      if (i >= j) {
        1
      } else if (dp(i)(j) >= 0) {
        dp(i)(j)
      } else {
        var ans = 0
        if (S(i) == 'I') {
          ans = modAdd(ans, dfs(i + 1, j))
        }

        if (S(j) == 'D') {
          ans = modAdd(ans, dfs(i, j - 1))
        }


        // 0, 1, 2, 3, 4, 5, n
        val n = j - i + 2

        var k = i + 1
        while (k < j + 1) {
          if (S(k - 1) == 'D' && S(k) == 'I') {
            val a = dfs(i, k - 2).toLong
            val b = dfs(k + 1, j).toLong
            val c = C(n - 1)(k - i)
            val d = ((a * b) % MOD * c) % MOD
            ans = modAdd(ans, d.toInt)
          }
          k += 1
        }

        dp(i)(j) = ans
        ans
      }
    }

    dfs(0, n - 1)
  }

  def numPermsDISequence2(S: String): Int = {
    val n = S.length
    val dp = Array.fill(n + 1, n + 1)(0)
    (0 to n).foreach(i => dp(0)(i) = 1)

    for {
      i <- 1 to n
      j <- 0 to i
    } {
      if (S(i - 1) == 'D') {
        for {
          k <- j until i
        } {
          dp(i)(j) = modAdd(dp(i)(j), dp(i - 1)(k))
        }
      } else {
        for {
          k <- 0 until j
        } {
          dp(i)(j) = modAdd(dp(i)(j), dp(i - 1)(k))
        }
      }
    }

    (0 to n).map(dp(n)(_)).foldLeft(0)(modAdd)
  }

  def numPermsDISequence1(S: String): Int = {
    val n = S.length
    if (n == 0) {
      0
    } else if (n == 1) {
      1
    } else {
      // when if we remove n from the permutation
      val mem = mutable.Map.empty[String, Int]

      mem("D") = 1
      mem("I") = 1

      def dfs(s: String): Int = {
        if (mem.contains(s)) {
          mem(s)
        } else {
          //          mem(s) = 0
          var res = 0
          if (s(0) == 'D') {
            res = modAdd(res, dfs(s.substring(1)))
          }
          var i = 0
          while (i < s.length - 1) {
            if (s(i) == 'I' && s(i + 1) == 'D') {
              res = modAdd(res, dfs(s.substring(0, i) + s.substring(i + 1)))
              res = modAdd(res, dfs(s.substring(0, i + 1) + s.substring(i + 2)))
            }

            i += 1
          }

          // i == s.length - 1
          if (s(i) == 'I') {
            res = modAdd(res, dfs(s.substring(0, i)))
          }

          mem(s) = res
          res
        }
      }

      val res = dfs(S)

      res
    }
  }

  private def modAdd(a: Int, b: Int): Int = {
    var c = a + b
    if (c >= MOD) {
      c -= MOD
    }
    c
  }
}
