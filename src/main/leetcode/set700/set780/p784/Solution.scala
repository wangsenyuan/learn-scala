package set700.set780.p784

object Solution {
  def letterCasePermutation(S: String): List[String] = {
    if (S.isEmpty) {
      List("")
    } else if (S(0).isDigit) {
      letterCasePermutation((S.tail)).map(s => "" + S(0) + s)
    } else {
      val x = if (S(0).isLower) {
        List(S(0), S(0).toUpper)
      } else {
        List(S(0), S(0).toLower)
      }
      val sub = letterCasePermutation(S.tail)

      (for {
        a <- x
        b <- sub
      } yield "" + a + b)
    }
  }
}
