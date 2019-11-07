package set1000.set1000.set1070.p1079

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def numTilePossibilities1(tiles: String): Int = {
    val n = tiles.length
    val N = 1 << n
    val set = mutable.Set.empty[String]

    def dfs(used: Int, str: String): Unit = {
      set += str
      if (used < N - 1) {
        for {
          i <- 0 until n
          if (used & (1 << i)) == 0
        } {
          dfs(used | (1 << i), str + tiles(i))
        }
      }
    }

    dfs(0, "")

    set.size - 1
  }

  def numTilePossibilities(tiles: String): Int = {
    val C = Array.ofDim[Int](8, 8)

    C(0)(0) = 1
    for {
      i <- 1 until 8
    } {
      C(i)(0) = 1
      C(i)(i) = 1
      for {
        j <- 1 until i
      } {
        C(i)(j) = C(i - 1)(j) + C(i - 1)(j - 1)
      }
    }


    val cnt = Array.ofDim[Int](26)

    val n = tiles.length

    val N = 1 << n

    val mem = mutable.Set.empty[String]

    var res = 0

    for {
      state <- 1 until N
    } {
      (0 until 26).foreach(cnt(_) = 0)
      val buf = ArrayBuffer.empty[Char]
      for {
        i <- 0 until n
        if (state & (1 << i)) > 0
      } {
        cnt(tiles(i) - 'A') += 1
        buf += tiles(i)
      }

      val s = buf.sorted.mkString("")
      if (!mem.contains(s)) {
        mem += s
        var tmp = 1
        var m = s.length
        for {
          c <- cnt
        } {
          tmp *= C(m)(c)
          m -= c
        }
        res += tmp
      }
    }

    res
  }
}
