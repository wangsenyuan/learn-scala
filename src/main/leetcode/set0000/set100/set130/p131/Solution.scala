package set0000.set100.set130.p131

object Solution {
  def partition(s: String): List[List[String]] = {
    if (s.isEmpty) {
      List(Nil)
    } else {
      val n = s.length
      val res = for {
        i <- 1 to n
        first = s.substring(0, i)
        second = s.substring(i)
        if isPalindrome(first)
      } yield {
        val res = partition(second)
        res.map(first :: _)
      }
      res.flatten.toList
    }
  }

  private def isPalindrome(s: String): Boolean = s.reverse == s
}
