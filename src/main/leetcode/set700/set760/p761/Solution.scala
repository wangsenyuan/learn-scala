package set700.set760.p761

import scala.collection.mutable.ArrayBuffer

object Solution {
  def makeLargestSpecial(S: String): String = {
    val n = S.length
    val dp = Array.ofDim[Int](n)

    val stack = Array.ofDim[Int](n)
    var p = 0
    var i = 0
    while(i < n) {
      if(S(i) == '1') {
        stack(p) = i
        p += 1
      } else {
        dp(stack(p - 1)) = i
        p -= 1
      }
      i += 1
    }

    def loop(start: Int, end: Int): String = {
      if(end - start + 1 == 2) {
        S.substring(start, end + 1)
      } else {
        if(dp(start) == end) {
          S.charAt(start) + loop(start + 1, end - 1) + S.charAt(end)
        } else {
          var i = start
          val buf = ArrayBuffer.empty[String]
          while(i < end) {
            val j = dp(i)
            buf += loop(i, j)
            i = j + 1
          }
          buf.sorted.reverse.toArray.mkString("")
        }
      }
    }

    loop(0, n - 1)
  }
}
