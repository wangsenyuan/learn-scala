package set300.set330.p336

object Solution {
  def palindromePairs(words: Array[String]): List[List[Int]] = {
    val ii = words.zipWithIndex.toMap
    val n = words.length
    var res = List.empty[List[Int]]
    for {
      i <- 0 until n
      word = words(i)
      j <- 0 to word.length
      (a, b) = word.splitAt(j)
    } {
      if (isPalindrome(b)) {
        val c = a.reverse
        if (ii.contains(c) && ii(c) != i) {
          res = List(i, ii(c)) :: res
        }
      }

      if (isPalindrome(a) && a.length > 0) {
        val c = b.reverse
        if (ii.contains(c) && ii(c) != i) {
          res = List(ii(c), i) :: res
        }
      }
    }

    res
  }

  private def isPalindrome(str: String): Boolean = {
    var i = 0
    var j = str.length - 1
    while (i < j && str(i) == str(j)) {
      i += 1
      j -= 1
    }
    i >= j
  }
}
