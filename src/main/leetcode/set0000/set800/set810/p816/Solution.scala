package set0000.set800.set810.p816

import scala.collection.mutable.ListBuffer

object Solution {
  def ambiguousCoordinates(S: String): List[String] = {
    val n = S.length

    def go(left: String, right: String): List[String] = {
      if (left.size == 0) {
        Nil
      } else {
        val sub = go(left.init, left.last +: right)

        val aa = rep(left)
        val bb = rep(right)

        val cur = {
          for {
            a <- aa
            b <- bb
          } yield {
            "(" + a + ", " +  b + ")"
          }
        }

        sub ++ cur
      }
    }

    val s = S.substring(1, S.length - 1)

    go(s.init, "" + s.last)
  }

  private def rep(s: String): List[String] = {
    if(s.size == 0) {
      Nil
    } else {
      val buf = ListBuffer.empty[String]
      if(s.length == 1 || s(0) != '0') {
        buf += s
      }
      val n = s.length
      var i = 1
      while (i < s.length) {
        // put dot at position i
        if(i > 1 && s(0) == '0') {
          // not valid
        } else if(s(n - 1) == '0') {
          // not valid
        } else {
          val a = s.substring(0, i)
          val b = s.substring(i)
          buf += (a + "." + b)
        }
        i += 1
      }

      buf.toList
    }

  }
}
