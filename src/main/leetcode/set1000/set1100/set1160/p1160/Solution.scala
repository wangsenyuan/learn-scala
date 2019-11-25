package set1000.set1100.set1160.p1160

object Solution {
  def countCharacters(words: Array[String], chars: String): Int = {
    val cnt = Array.ofDim[Int](26)
    chars.foreach(c => cnt(c - 'a') += 1)

    val cnt2 = Array.ofDim[Int](26)

    def good(word: String): Boolean = {
      (0 until 26).foreach(i => cnt2(i) = 0)
      word.foreach(c => cnt2(c - 'a') += 1)
      cnt2.zip(cnt).forall(x => x._1 <= x._2)
    }

    words.filter(good).map(_.length).sum
  }
}
