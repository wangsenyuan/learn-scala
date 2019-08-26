package set0000.set800.set850.p859

object Solution {
  def buddyStrings(A: String, B: String): Boolean = {
    if (A.length != B.length) {
      false
    } else {
      val n = A.length
      var i = 0
      while (i < n && A(i) == B(i)) {
        i += 1
      }

      if (i == n) {
        A.groupBy(identity).exists(_._2.size > 1)
      } else {
        var j = i + 1
        while (j < n && A(j) == B(j)) {
          j += 1
        }
        if (j == n) {
          false
        } else {
          if (A(i) != B(j) || A(j) != B(i)) {
            false
          } else {
            j += 1
            while (j < n && A(j) == B(j)) {
              j += 1
            }
            j == n
          }
        }
      }
    }
  }
}
