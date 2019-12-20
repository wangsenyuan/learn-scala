package set1000.set1200.set1250.p1255

object Solution {
  def maxScoreWords(words: Array[String], letters: Array[Char], score: Array[Int]): Int = {
    val cnt1 = Array.ofDim[Int](26)
    letters.foreach(c => cnt1(c - 'a') += 1)
    var best = 0
    val n = words.length
    val N = 1 << n
    val cnt2 = Array.ofDim[Int](26)
    var state = 1
    while (state < N) {
      (0 until 26).foreach(j => cnt2(j) = 0)
      var earn = 0
      var can = true
      var i = 0
      while (i < n && can) {
        if ((state & (1 << i)) > 0) {
          val word = words(i)
          var j = 0
          while (j < word.length && can) {
            val c = word(j) - 'a'
            earn += score(c)
            cnt2(c) += 1
            can = cnt2(c) <= cnt1(c)
            j += 1
          }
        }
        i += 1
      }

      if (can) {
        best = best max earn
      }
      state += 1
    }

    best
  }
}
