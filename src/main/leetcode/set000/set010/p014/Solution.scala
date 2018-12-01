package set000.set010.p014

object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    def go(i: Int, cur: String): String = {
      if (i == strs.length || cur.isEmpty) {
        cur
      } else {
        go(i + 1, commonPrefix(cur, strs(i)))
      }
    }

    if (strs != null && strs.length > 0) {
      go(1, strs(0))
    } else {
      ""
    }
  }

  def commonPrefix(a: String, b: String): String = {
    a.zip(b).takeWhile(x => x._1 == x._2).map(_._1).mkString
  }
}
