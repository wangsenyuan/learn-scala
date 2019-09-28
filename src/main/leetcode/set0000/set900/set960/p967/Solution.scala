package set0000.set900.set960.p967

import scala.collection.mutable.ArrayBuffer

object Solution {
  def numsSameConsecDiff(N: Int, K: Int): Array[Int] = {
    if (N == 1) {
      Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    } else {
      val base = (0 until N).fold(1)((r, _) => r * 10)

      def dfs(n: Int, base: Int): Array[Int] = {
        if (n == 1) {
          Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        } else {
          val res = dfs(n - 1, base / 10)
          val buf = ArrayBuffer.empty[Int]
          for {
            x <- res
          } {
            val firstDigit = x * 10 / base
            if (firstDigit >= K) {
              buf += (firstDigit - K) * base + x
            }
            if (firstDigit + K <= 9) {
              buf += (firstDigit + K) * base + x
            }
          }
          buf.toArray
        }
      }

      val res = dfs(N, base / 10)
      res.filter(x => x.toLong * 10 / base > 0).distinct
    }
  }
}
