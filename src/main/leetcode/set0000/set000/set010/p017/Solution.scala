package set0000.set000.set010.p017

object Solution {
  val map = Array("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

  def letterCombinations(digits: String): List[String] = {
    if (digits == null || digits.size == 0) {
      Nil
    } else {
      def go(digits: String, prefix: String): IndexedSeq[String] = {
        if (digits.isEmpty) {
          Vector(prefix)
        } else {
          val x = digits(0) - '0'
          map(x).flatMap(y => go(digits.tail, prefix + y))
        }
      }

      go(digits, "").toList
    }
  }


}
