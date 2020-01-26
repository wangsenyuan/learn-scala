package set1000.set1300.set1320.p1328

object Solution {
  def breakPalindrome(palindrome: String): String = {
    val n = palindrome.length
    if (n == 1) {
      ""
    } else {
      val cs = palindrome.toCharArray
      val h = n / 2
      var i = 0
      while (i <= h && cs(i) == 'a') {
        i += 1
      }
      if (i < h) {
        //find a one not 'a'
        cs(i) = 'a'
      } else {
        cs(n - 1) = 'b'
      }
      cs.mkString("")
    }
  }
}
