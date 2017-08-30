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
