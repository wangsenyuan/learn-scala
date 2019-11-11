package set1000.set1000.set1090.p1096

import scala.collection.mutable.ArrayBuffer

object Solution {
  def braceExpansionII(expression: String): List[String] = {
    val n = expression.length
    val stack = Array.ofDim[Int](n)
    var p = 0

    val pp = Array.ofDim[Int](n)

    var i = 0
    while (i < n) {
      if (expression.charAt(i) == '{') {
        stack(p) = i
        p += 1
      } else if (expression.charAt(i) == '}') {
        pp(stack(p - 1)) = i
        p -= 1
      }
      i += 1
    }


    def appendResult(start: Int, buf: ArrayBuffer[R], j: Int, r: R) = {
      if (buf.length > 0 && j > start && expression.charAt(j - 1) != ',') {
        buf(buf.length - 1) = buf(buf.length - 1).concatenate(r)
      } else {
        buf += r
      }
    }

    def parse(start: Int, end: Int): R = {
      val buf = ArrayBuffer.empty[R]
      var j = start
      var i = start
      while (i <= end) {
        if (i == end || expression.charAt(i) == ',' || expression.charAt(i) == '{') {
          if (i > j) {
            appendResult(start, buf, j, new R(Set(expression.substring(j, i))))
          }
          j = i + 1
        }

        if (i < end && expression.charAt(i) == '{') {
          appendResult(start, buf, i, parse(i + 1, pp(i)))
          i = pp(i)
          j = i + 1
        }

        i += 1
      }

      buf.reduce(_.union(_))
    }

    val r = parse(0, n)
    r.words.toList.sorted
  }

  class R(val words: Set[String]) {
    def union(that: R): R = {
      val ws = this.words ++ that.words
      new R(ws)
    }

    def concatenate(that: R): R = {
      val ws = for {
        a <- this.words
        b <- that.words
      } yield {
        a + b
      }
      new R(ws)
    }
  }

}
