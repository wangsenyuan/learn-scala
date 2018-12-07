package set000.set030.p032

import scala.annotation.tailrec

object Solution {

  def longestValidParentheses(s: String): Int = {

    @tailrec
    def go(left: Vector[Int], right: Vector[Int], cur: Int): Int = {
      if (right.isEmpty) {
        cur
      } else if (s(right.head) == ')' && !left.isEmpty && s(left.last) == '(') {
        val init = left.init
        if (init.isEmpty) {
          go(init, right.tail, right.head + 1)
        } else {
          go(init, right.tail, cur max (right.head - init.last))
        }
      } else {
        go(left :+ right.head, right.tail, cur)
      }
    }

    go(Vector.empty, (0 until s.length).toVector, 0)
  }

  def longestValidParentheses1(s: String): Int = {
    val n = s.length
    val stack = Array.fill(n)(-1)
    var p = 0
    var i = 0
    var best = 0
    while (i < n) {
      if (s(i) == ')' && p > 0 && s(stack(p - 1)) == '(') {
        p -= 1
        if (p > 0) {
          best = best max (i - stack(p - 1))
        } else {
          best = i + 1
        }
      } else {
        stack(p) = i
        p += 1
      }

      i += 1
    }

    best
  }
}
