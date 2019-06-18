package set700.set750.p756

import scala.collection.mutable

object Solution {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    val suf = Array.ofDim[String](26, 26)

    allowed.foreach(word => {
      val a = word(0) - 'A'
      val b = word(1) - 'A'
      val c = word(2)
      val x = suf(a)(b)
      if(x == null) {
        suf(a)(b) = "" + c
      } else if(x.indexOf(c) < 0) {
        suf(a)(b) += c
      }
    })

    def next(str: String): Array[String] = {
      val res = mutable.ArrayBuffer.empty[String]
      def dfs(i: Int, s: String): Unit = {
        if(i == str.length - 1) {
          res += s
        } else {
          val a = str(i) - 'A'
          val b = str(i + 1) - 'A'
          val x = suf(a)(b)
          if(x != null && !x.isEmpty) {
            x.foreach(c => dfs(i + 1, s + c))
          }
        }
      }

      dfs(0, "")

      res.toArray
    }

    val mem = mutable.Set.empty[String]

    def loop(cur: String): Boolean = {
      if(cur.length == 1) {
        true
      } else if(mem(cur)) {
        false
      } else {
        mem(cur) = true
        val nxts = next(cur)
        nxts.exists(loop)
      }
    }

    loop(bottom)
  }
}
