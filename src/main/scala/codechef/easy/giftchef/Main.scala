package codechef.easy.giftchef

import scala.collection.mutable.ListBuffer
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

  val MOD = 1000000007

  def solve(): Unit = {
    val s = StdIn.readLine()
    val t = StdIn.readLine()
    val n = s.length
    val m = t.length

    val lps = computeLps(t)

    val a = Array.fill(n + 1)(false)

    var i = 0
    var j = 0
    while (i < n) {
      if (s(i) == t(j)) {
        i += 1
        j += 1
      }

      if (j == m) {
        a(i) = true
        j = lps(j - 1)
      } else if (i < n && s(i) != t(j)) {
        if (j > 0) {
          j = lps(j - 1)
        } else {
          i += 1
        }
      }
    }

    val dp = Array.fill(s.length + 1)(0L)
    dp(0) = 1

    i = 1
    while (i <= n) {
      if (a(i)) {
        dp(i) = dp(i - m)
      }
      dp(i) = (dp(i) + dp(i - 1)) % MOD
      i += 1
    }

    val ans = (dp(n) - 1 + MOD) % MOD
    println(ans)
  }

  def computeLps(pat: String): Array[Int] = {
    val n = pat.length
    val lps = Array.fill(n)(0)
    var len = 0
    var i = 1
    while (i < n) {
      if (pat(i) == pat(len)) {
        len += 1
        lps(i) = len
        i += 1
      } else {
        if (len > 0) {
          len = lps(len - 1)
        } else {
          lps(i) = 0
          i += 1
        }
      }
    }

    lps
  }


  def solve1(): Unit = {
    val s = StdIn.readLine()
    val t = StdIn.readLine()
    val m = t.length
    val pos = getPos(s, t)
    val a = Array.fill(s.length + 1)(false)
    pos.foreach(x => a(x) = true)

    val dp = Array.fill(s.length + 1)(0L)
    dp(0) = 1

    var i = 1
    while (i <= s.length) {
      if (a(i)) {
        dp(i) = dp(i - m)
      }
      dp(i) = (dp(i) + dp(i - 1)) % MOD
      i += 1
    }

    val ans = (dp(s.length) - 1 + MOD) % MOD
    println(ans)
  }

  def getPos(s: String, t: String): Array[Int] = {
    val x = t + "#" + s
    val n = x.length
    val m = t.length
    val p = Array.fill(n)(0)
    var i = 1
    while (i < n) {
      var j = p(i - 1)
      while (j > 0 && x(j) != x(i)) {
        j = p(j - 1)
      }

      if (x(j) == x(i)) {
        j += 1
      }
      p(i) = j
      i += 1
    }

    val ans = ListBuffer.empty[Int]
    i = m + m
    while (i < n) {
      if (p(i) == m) {
        ans += i - m
      }
      i += 1
    }
    ans.toArray
  }
}
