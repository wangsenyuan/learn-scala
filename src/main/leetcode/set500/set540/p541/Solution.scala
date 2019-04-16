package set500.set540.p541

object Solution {
  def reverseStr(s: String, k: Int): String = {
    val cs = s.toCharArray
    val n = cs.length
    var i = 0
    while(i < n) {
      val j = (i + 2 * k) min n

      reverse(cs, i, j min (i + k))

      i = j
    }

    new String(cs)
  }

  private def reverse(chars: Array[Char], left: Int, right: Int): Unit = {
    var i = left
    var j = right - 1
    while(i < j) {
      val x = chars(i)
      chars(i) = chars(j)
      chars(j) = x
      i += 1
      j -= 1
    }
  }
}
