package set400.set420.p421


object Solution {
  def findMaximumXOR(nums: Array[Int]): Int = {
    val root = new Trie

    nums.foreach(num => root.add(num, 31))

    var best = 0

    nums.foreach(num => {
      best = best max root.xor(num, 31, 0)
    })

    best
  }

  class Trie {
    val children: Array[Trie] = Array.fill[Trie](2)(null)

    def add(num: Int, pos: Int): Unit = {
      if(pos >= 0) {
        val b = (num >> pos) & 1
        if(children(b) == null) {
          children(b) = new Trie
        }
        children(b).add(num, pos - 1)
      }
    }

    def xor(num: Int, pos: Int, ans: Int): Int = {
      if(pos < 0) {
        ans
      } else {
        val b = ((num >> pos) & 1) ^ 1
        if(children(b) != null) {
          children(b).xor(num, pos - 1, ans | (1 << pos))
        } else {
          // this have to be true, as the num itself will contribute it
          children(b ^ 1).xor(num, pos - 1, ans)
        }
      }
    }
  }

}
