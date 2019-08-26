package set0000.set500.set500.p500

object Solution {
  def findWords(words: Array[String]): Array[String] = {
    val row0 = Set('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P')
    val row1 = Set('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L')
    val row2 = Set('Z', 'X', 'C', 'V', 'B', 'N', 'M')

    def checkRow(word: String, row: Set[Char]): Boolean = {
      word.forall(c => row.contains(c.toUpper))
    }

    def check(word: String): Boolean = {
      checkRow(word, row0) || checkRow(word, row1) || checkRow(word, row2)
    }

    words.filter(check)
  }
}
