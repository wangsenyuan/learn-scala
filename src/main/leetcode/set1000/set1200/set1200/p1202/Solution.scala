package set1000.set1200.set1200.p1202

import scala.util.Sorting

object Solution {
  def smallestStringWithSwaps(s: String, pairs: List[List[Int]]): String = {
    val n = s.length

    val uf = new UF(n)
    pairs.foreach(pair => uf.union(pair.head, pair.last))

    val cs = s.toCharArray.zipWithIndex

    val xs = cs.map(c => Pos(c._2, uf.find(c._2), c._1))

    val gs = xs.groupBy(_.p)

    gs.foreach(g => {
      val arr = g._2
      Sorting.quickSort(arr)(Ordering.by(_.c))
    })

    val pos = Array.ofDim[Int](n)

    val buf = Array.ofDim[Char](n)

    var i = 0
    while (i < n) {
      val p = uf.find(i)
      buf(i) = gs(p)(pos(p)).c
      pos(p) += 1

      i += 1
    }

    buf.mkString("")
  }

  case class Pos(i: Int, p: Int, c: Char)

  class UF(_n: Int) {
    val arr = Array.ofDim[Int](_n)
    val cnt = Array.ofDim[Int](_n)

    for {
      i <- 0 until _n
    } {
      arr(i) = i
      cnt(i) = 1
    }

    def find(x: Int): Int = {
      if (arr(x) != x) {
        arr(x) = find(arr(x))
      }
      arr(x)
    }

    def union(a: Int, b: Int): Boolean = {
      val pa = find(a)
      val pb = find(b)
      if (pa == pb) {
        false
      } else {
        if (cnt(pa) >= cnt(pb)) {
          arr(pb) = pa
          cnt(pa) += cnt(pb)
        } else {
          arr(pa) = pb
          cnt(pb) += cnt(pa)
        }
        true
      }
    }
  }

}
