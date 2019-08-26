package set0000.set500.set550.p557

object Solution {
  def reverseWords(s: String): String = {
    val words = s.split(" ")
    val rw = words.map(reverseWord)
    rw.mkString(" ")
  }

  private def reverseWord(word: String): String = word.reverse
}
