package set0000.set000.set020.p022

import scala.collection.mutable.ListBuffer

object Solution {
  def generateParenthesis(n: Int): List[String] = {
    val res = ListBuffer.empty[String]

    def go(open: Int, close: Int, str: String): Unit = {
      if (open == close && open == n) {
        res += str
      } else {
        if (open < n) {
          go(open + 1, close, str + "(")
        }
        if (close < open) {
          go(open, close + 1, str + ")")
        }
      }
    }

    go(0, 0, "")
    res.toList
  }

  def generateParenthesis1(n: Int): List[String] = {
    val res = ListBuffer.empty[String]

    def go(open: Int, close: Int, str: String): Unit = {
      if (str.length == 2 * n) {
        res += str
      } else {
        if (open > 0) {
          go(open - 1, close + 1, str + "(")
        }
        if (close > 0) {
          go(open, close - 1, str + ")")
        }
      }
    }

    go(n, 0, "")

    res.toList
  }
}
