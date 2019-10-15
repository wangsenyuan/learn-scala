package set1000.set1000.set1000.p1003

object Solution {
  def isValid(S: String): Boolean = {
    val cnt = Array.ofDim[Int](3)

    var valid = true

    var i = 0
    while (i < S.length && valid) {
      // X + abc + Y
      // X + Y is valid
      val x = S(i)
      cnt(x - 'a') += 1

      valid = cnt(0) >= cnt(1) && cnt(1) >= cnt(2)

      if (i > 0) {
        if (x == 'b' && S(i - 1) == 'b') {
          valid = false
        } else if (x == 'c' && S(i - 1) == 'a') {
          valid = false
        }
      }

      i += 1
    }

    valid && cnt(0) == cnt(1) && cnt(1) == cnt(2)
  }
}
