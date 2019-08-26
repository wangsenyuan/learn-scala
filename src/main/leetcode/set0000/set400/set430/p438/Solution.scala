package set0000.set400.set430.p438

import scala.collection.mutable.ListBuffer

object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    if (s.length < p.length) {
      Nil
    } else {
      val pc = Array.ofDim[Int](26)
      for {
        c <- p
      } {
        pc(c - 'a') += 1
      }
      val sc = Array.ofDim[Int](26)
      var i = 0
      while (i < p.length) {
        sc(s(i) - 'a') += 1
        i += 1
      }

      val res = ListBuffer.empty[Int]
      if (allMatch(sc, pc)) {
        res += 0
      }
      val pn = p.length
      while (i < s.length) {
        sc(s(i) - 'a') += 1
        sc(s(i - pn) - 'a') -= 1
        if(sc(s(i) - 'a') == pc(s(i) - 'a') && allMatch(sc, pc)) {
          res += i - pn + 1
        }
        i += 1
      }

      res.toList
    }
  }

  private def allMatch(a: Array[Int], b: Array[Int]): Boolean = {
    a.zip(b).forall(x => x._1 == x._2)
  }
}
