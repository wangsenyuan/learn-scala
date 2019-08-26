package set0000.set300.set310.p318

object Solution {
  def maxProduct(words: Array[String]): Int = {
    val n = words.length
    val rep = Array.ofDim[Int](n)

    var i = 0
    while (i < n) {
      val word = words(i)
      var j = 0
      var bit = 0
      while (j < word.length) {
        val x = word(j) - 'a'
        bit |= 1 << x
        j += 1
      }
      rep(i) = bit
      i += 1
    }
    var best = 0
    for {
      i <- 0 until n - 1
      j <- i + 1 until n
      if (rep(i) & rep(j)) == 0
    } {
      val tmp = words(i).length * words(j).length
      best = tmp max best
    }

    best
  }
}
