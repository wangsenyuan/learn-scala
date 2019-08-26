package set0000.set400.set430.p433

import scala.collection.mutable.ArrayBuffer

object Solution {
  def minMutation(start: String, end: String, bank: Array[String]): Int = {
    if (bank.isEmpty) {
      if (start == end) {
        0
      } else {
        -1
      }
    } else {
      val bankSet = bank.toSet
      if(!bankSet.contains(end)) {
        -1
      } else {
        val n = bank.size

        val vis = Array.ofDim[Boolean](n)
        val dp = Array.fill(n)(Int.MaxValue)

        val ii = bank.zip(bank.indices).toMap
        val que = Array.ofDim[Int](n)
        var front = 0
        var tail = 0
        que(tail) = ii(end)
        dp(ii(end)) = 0
        vis(ii(end)) = true
        tail += 1
        while (front < tail) {
          val i = que(front)
          front += 1

          val ss = mutate(bank(i))
          if (ss.contains(start)) {
            return dp(i) + 1
          }

          for {
            s <- ss
            if (bankSet.contains(s))
            j = ii(s)
            if (!vis(j))
          } {
            vis(j) = true
            dp(j) = dp(i) + 1
            que(tail) = j
            tail += 1
          }
        }

        return -1
      }
    }
  }


  def minMutation1(start: String, end: String, bank: Array[String]): Int = {
    val bankSet = bank.toSet

    def go(cur: String, vis: Set[String]): Int = {
      if (cur == end) {
        vis.size
      } else {
        mutate(cur).filter(bankSet).filterNot(vis).map(str => go(str, vis + cur)).foldLeft(Int.MaxValue)(_ min _)
      }
    }

    val res = go(start, Set.empty)
    if (res == Int.MaxValue) {
      -1
    } else {
      res
    }
  }

  val gens = "ACGT"

  private def mutate(str: String): Array[String] = {
    val cs = str.toCharArray()
    val res = ArrayBuffer.empty[String]
    for {
      i <- 0 until 8
      j <- 0 until 4
      if (cs(i) != gens(j))
    } {
      cs(i) = gens(j)
      res += new String(cs)
      cs(i) = str(i)
    }

    res.toArray
  }
}
