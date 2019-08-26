package set0000.set100.set160.p166

import scala.collection.mutable

object Solution {

  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val sign = if (numerator == 0 || (numerator > 0) == (denominator > 0)) {
      ""
    } else {
      "-"
    }
    val num = numerator.toLong.abs
    val deno = denominator.toLong.abs
    val first = num / deno
    val rem = num % deno
    if (rem == 0) {
      sign + first
    } else {
      val seen = mutable.Map.empty[Long, Int]

      def go(res: String, cur: Long): String = {
        if (cur == 0) {
          res
        } else {
          seen.get(cur) match {
            case None =>
              seen(cur) = res.length
              go(res + ((cur * 10) / deno), ((cur * 10) % deno))
            case Some(pos) =>
              val ans = res.substring(0, pos)
              val rep = res.substring(pos)
              ans + "(" + rep + ")"
          }
        }
      }

      go(sign + first + ".", rem.abs)
    }
  }
}
