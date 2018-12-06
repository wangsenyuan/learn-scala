package set000.set030.p030

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {

  def calculatePrefixSum(s: String, n: Int) = {
    val arr = Array.fill(26, n + 1)(0)
    var i = 1
    while (i <= n) {
      var j = 0
      while (j < 26) {
        arr(j)(i) = arr(j)(i - 1)
        j += 1
      }

      arr(s(i - 1) - 'a')(i) += 1

      i += 1
    }
    arr
  }

  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (s.isEmpty || words.isEmpty) {
      Nil
    } else {
      val count = words.groupBy(identity).mapValues(_.size).toList
      val m = words.length
      val k = words(0).length

      def check2(s: String): Boolean = {
        val tmp = mutable.Map(count: _*)
        var i = 0
        var can = true
        while (i < s.length && can) {
          val x = s.substring(i, i + k)
          val y = tmp.getOrElse(x, 0)
          can = y > 0
          if (can) {
            tmp.put(x, y - 1)
          }

          i += k
        }
        can
      }

      val n = s.length
      val fp = calculatePrefixSum(s, n)

      val gp = calculatePrefixSum(words.mkString(""), m * k)
      val res = ListBuffer.empty[Int]
      var i = 0
      while (i + m * k <= n) {
        val right = i + m * k
        var j = 0
        var can = true
        while (j < 26 && can) {
          can = gp(j)(m * k) == (fp(j)(right) - fp(j)(i))
          j += 1
        }
        can = can && check2(s.substring(i, right))
        if (can) {
          res += i
        }
        i += 1
      }

      res.toList
    }
  }
}
