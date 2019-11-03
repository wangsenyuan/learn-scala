package set1000.set1000.set1040.p1044

import scala.collection.mutable
import scala.util.Sorting

object Solution {

  class Node(val pos: Int) extends Ordered[Node] {
    val rank = Array.ofDim[Int](2)

    override def compare(that: Node): Int = {
      if (this.rank(0) < that.rank(0)) {
        -1
      } else if (this.rank(0) > that.rank(0)) {
        1
      } else {
        this.rank(1) - that.rank(1)
      }
    }
  }

  private def buildSuffixArray(s: String): Array[Int] = {
    val n = s.length
    val nodes = Array.ofDim[Node](n)
    for {
      i <- 0 until n
    } {
      nodes(i) = new Node(i)
      nodes(i).rank(0) = s(i) - 'a'
      if (i + 1 < n) {
        nodes(i).rank(1) = s(i + 1) - 'a'
      } else {
        nodes(i).rank(1) = -1
      }
    }

    Sorting.stableSort(nodes)

    val ind = Array.ofDim[Int](n)

    var k = 4
    while (k < 2 * n) {
      var rank = 0
      var prev = nodes(0).rank(0)
      nodes(0).rank(0) = rank
      ind(nodes(0).pos) = 0

      var i = 1
      while (i < n) {
        if (nodes(i).rank(0) == prev && nodes(i).rank(1) == nodes(i - 1).rank(1)) {
          prev = nodes(i).rank(0)
          nodes(i).rank(0) = rank
        } else {
          prev = nodes(i).rank(0)
          rank += 1
          nodes(i).rank(0) = rank
        }
        ind(nodes(i).pos) = i
        i += 1
      }

      i = 0
      while (i < n) {
        val j = nodes(i).pos + k / 2
        nodes(i).rank(1) = -1
        if (j < n) {
          nodes(i).rank(1) = nodes(ind(j)).rank(0)
        }

        i += 1
      }

      Sorting.stableSort(nodes)

      k *= 2
    }

    nodes.map(_.pos)
  }

  def longestDupSubstring(s: String): String = {
    val suffixArray = buildSuffixArray(s)
    val n = s.length

    val inv = Array.ofDim[Int](n)

    for {
      i <- 0 until n
    } {
      inv(suffixArray(i)) = i
    }

    val lcp = Array.ofDim[Int](n)
    var k = 0
    for {
      i <- 0 until n
      if inv(i) < n - 1
    } {
      val j = suffixArray(inv(i) + 1)
      while (i + k < n && j + k < n && s(i + k) == s(j + k)) {
        k += 1
      }
      lcp(inv(i)) = k
      if (k > 0) {
        k -= 1
      }
    }

    var best = 0
    var pos = 0
    for {
      i <- 0 until n
    } {
      if (lcp(i) > best) {
        best = lcp(i)
        pos = i
      }
    }

    if (best == 0) {
      ""
    } else {
      s.substring(suffixArray(pos), suffixArray(pos) + best)
    }
  }

  def longestDupSubstring1(S: String): String = {
    val n = S.length
    val MOD = 1000000000007L

    def check(k: Int): Int = {
      val set = mutable.Set.empty[Long]
      var base = 1L
      var sum = 0L
      var i = 0
      while (i < k) {
        sum = sum * 31 + S(i) - 'a'
        sum %= MOD

        base *= 31
        base %= MOD

        i += 1
      }

      set += sum

      while (i < n) {
        sum = sum * 31 + S(i) - 'a'
        sum %= MOD

        val x = (S(i - k) - 'a').toLong
        sum -= (x * base) % MOD

        if (sum < 0) {
          sum += MOD
        }

        if (set.contains(sum)) {
          return i - k
        }

        set += sum

        i += 1
      }

      -1
    }

    var left = 1
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid) < 0) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    if (right <= 1) {
      ""
    } else {
      val i = check(right - 1)
      S.substring(i + 1, i + right)
    }
  }
}
