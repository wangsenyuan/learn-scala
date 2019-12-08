package set1000.set1100.set1190.p1190

import scala.collection.mutable.ArrayBuffer

object Solution {
  def reverseParentheses(s: String): String = {
    val n = s.length

    val stack = Array.ofDim[Int](n)
    val pair = Array.fill(n)(-1)
    var p = 0

    for {
      i <- 0 until n
    } {
      if (s(i) == '(') {
        stack(p) = i
        p += 1
      } else if (s(i) == ')') {
        pair(stack(p - 1)) = i
        p -= 1
      }
    }

    val buf = s.toCharArray

    def dfs(left: Int, right: Int, reverse: Boolean): Block = {
      val blocks = ArrayBuffer.empty[Block]
      var i = left
      while (i <= right) {
        if (pair(i) > i) {
          blocks += dfs(i + 1, pair(i) - 1, !reverse)
          i = pair(i)
        } else {
          blocks += Block(buf, i, i, null, false)
        }
        i += 1
      }
      Block(buf, left, right, blocks.toArray, reverse)
    }

    val root = dfs(0, n - 1, false)
    root.mkString()
  }

  case class Block(buf: Array[Char], left: Int, right: Int, blocks: Array[Block], reverse: Boolean) {

    def mkString(): String = {
      if (left > right) {
        ""
      } else if (left == right) {
        buf(left).toString
      } else if (!reverse) {
        blocks.map(_.mkString()).reduce(_ + _)
      } else {
        blocks.reverse.map(_.mkString()).reduce(_ + _)
      }
    }
  }

}
