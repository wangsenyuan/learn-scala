package set000.set030.p038

object Solution {

  def countAndSay(n: Int): String = {
    def go(k: Int, prev: String): String = {
      if (k == n) {
        prev
      } else {
        go(k + 1, say(prev))
      }
    }

    go(1, "1")
  }

  private def say(str: String): String = {
    val n = str.length
    val buf = new StringBuilder()
    var j = 0
    var i = 1
    while (i <= n) {
      if (i == n || str(i) != str(j)) {
        buf.append(i - j)
        buf.append(str(j))
        j = i
      }
      i += 1
    }
    buf.mkString
  }
}
