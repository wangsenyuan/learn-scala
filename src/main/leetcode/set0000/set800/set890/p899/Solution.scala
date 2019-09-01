package set0000.set800.set890.p899

object Solution {

  case class Pos(start: Int, cur: Int)

  def orderlyQueue(S: String, K: Int): String = {
    if (K == 1) {
      var ans = S
      for {
        i <- 1 until S.length
        str = S.substring(i) + S.substring(0, i)
        if (str < ans)
      } {
        ans = str
      }

      ans

      //      val n = S.length
      //
      //      val candBuf = ArrayBuffer.empty[Pos]
      //
      //      (0 until n).foreach(i => {
      //        candBuf += Pos(i, i)
      //      })
      //      val tmp = ArrayBuffer.empty[Pos]
      //      var k = 1
      //      while (candBuf.size > 1 && k < n) {
      //        tmp.clear()
      //
      //        var x = S(candBuf(0).cur)
      //        var i = 1
      //        while (i < candBuf.size) {
      //          if (x > S(candBuf(i).cur)) {
      //            x = S(candBuf(i).cur)
      //          }
      //          i += 1
      //        }
      //        i = 0
      //        while (i < candBuf.size) {
      //          if (x == S(candBuf(i).cur)) {
      //            val j = (candBuf(i).cur + 1) % n
      //            tmp += candBuf(i).copy(cur = j)
      //          }
      //          i += 1
      //        }
      //        candBuf.clear()
      //        candBuf ++= tmp
      //        k += 1
      //      }
      //
      //      val ans = candBuf(0)
      //
      //      S.substring(ans.start) + S.substring(0, ans.start)
    } else {
      val cs = S.toCharArray.sorted
      cs.mkString("")
    }
  }
}
