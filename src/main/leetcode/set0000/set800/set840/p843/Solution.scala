package set0000.set800.set840.p843

/**
 * // This is the Master's API interface.
 **/
// You should not implement it, or speculate about its implementation
trait Master {
  def guess(word: String): Int
}

object Solution {
  def findSecretWord(wordlist: Array[String], master: Master): Unit = {
    if (wordlist.size == 1) {
      master.guess(wordlist(0))
    } else if (wordlist.size > 1) {
      var best = ""
      var bestMaj = wordlist.length
      var count: Map[Int, Array[String]] = null
      wordlist.foreach(word => {
        val bySame = wordlist.groupBy(that => sameLetters(word, that))
        var maj = 0
        bySame.foreach(p => {
          val (_, arr) = p
          if (arr.length > maj) {
            maj = arr.length
          }
        })

        if (maj < bestMaj) {
          bestMaj = maj
          best = word
          count = bySame
        }
      })

      val ans = master.guess(best)
      if (ans < best.length) {
        // still need guess
        val cand = count(ans)
        findSecretWord(cand, master)
      }
    }
  }

  private def sameLetters(a: String, b: String) = a.zip(b).count(p => p._1 == p._2)

}
