package set400.set480.p482

import scala.collection.mutable.ArrayBuffer

object Solution {
  def licenseKeyFormatting(S: String, K: Int): String = {
    val res = ArrayBuffer.empty[String]
    val buf = new StringBuilder()

    var n = S.length - 1
    while(n >= 0) {
      if(S(n) != '-') {
        buf.append(S(n).toUpper)
        if(buf.length == K) {
          res += buf.reverse.toString()
          buf.clear()
        }
      }
      n -= 1
    }
    if(buf.length > 0) {
      res += buf.reverse.toString()
    }

    res.reverse.mkString("-")
  }
}
