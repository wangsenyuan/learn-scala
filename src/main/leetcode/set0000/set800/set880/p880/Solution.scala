package set0000.set800.set880.p880

object Solution {
  def decodeAtIndex(S: String, K: Int): String = {
    val n = S.length

    def go(i: Int, len: Int, k: Int): String = {
      if (i >= n) {
        // normally not the case
        ""
      } else {
        val c = S(i)
        if (c >= '2' && c <= '9') {
          val newLen = (c - '0').toLong * len
          if (newLen >= k) {

            if (k % len == 0) {
              go(0, 0, len)
            } else {
              go(0, 0, k % len)
            }
          } else {
            go(i + 1, newLen.toInt, k)
          }
        } else {
          val newLen = len + 1
          if (newLen == k) {
            S.substring(i, i + 1)
          } else {
            go(i + 1, newLen, k)
          }
        }
      }
    }

    go(0, 0, K)
  }
}
