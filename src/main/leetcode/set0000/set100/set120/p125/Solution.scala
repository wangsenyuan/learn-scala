package set0000.set100.set120.p125

object Solution {
  def isPalindrome(s: String): Boolean = {
    val t = s.filter(isAlphanumeric).toLowerCase
    t.reverse == t
  }

  private def isAlphanumeric(c: Char): Boolean = c.isLetterOrDigit
}
