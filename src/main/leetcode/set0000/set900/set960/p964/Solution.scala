package set0000.set900.set960.p964

import scala.collection.mutable

object Solution {


  def leastOpsExpressTarget1(x: Int, target: Int): Int = {
    // x * x ... * x + x * x + x / x
    val mem = mutable.Map.empty[Int, Int]

    def dfs(y: Int): Int = {
      if (x == y) {
        0
      } else if (x > y) {
        if (y <= x / 2) {
          2 * y - 1
        } else {
          (x - y) * 2
        }
      } else if (mem.contains(y)) {
        mem(y)
      } else {
        mem(y) = Int.MaxValue >> 1
        // x < y
        var X = x
        var i = 0
        while (X * x < y) {
          X *= x
          i += 1
        }
        val Z = X * x
        // X < y && X * x >= y
        val res =
          if (Z == y) {
            i + 1
          } else {
            // Z > y
            val cnt1 = (i + 1) + 1 + dfs(Z - y)
            val a = y / X
            val cnt2 = a * i + a + dfs(y - a * X)
            cnt1 min cnt2
          }

        mem(y) = res
        res
      }
    }

    dfs(target)
  }

  def leastOpsExpressTarget(x: Int, target: Int): Int = {
    // x * x ... * x + x * x + x / x

    val mem = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, target: Int): Int = {
      val key = i -> target
      if (mem.contains(key)) {
        mem(key)
      } else if (target == 0) {
        0
      } else if (target == 1) {
        cost(i)
      } else if (i >= 39) {
        target + 1
      } else {
        val t = target / x
        val r = target % x
        val ans = (r * cost(i) + dfs(i + 1, t)) min ((x - r) * cost(i) + dfs(i + 1, t + 1))
        mem(key) = ans
        ans
      }
    }

    dfs(0, target) - 1
  }

  private def cost(x: Int) = if (x > 0) x else 2
}
