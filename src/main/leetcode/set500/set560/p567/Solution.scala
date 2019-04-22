package set500.set560.p567

object Solution {
  def checkInclusion(s1: String, s2: String): Boolean = {

    val m = s1.length
    val count1 = Array.ofDim[Int](26)

    for {
      c <- s1
    } {
      count1(c - 'a') += 1
    }

    val n = s2.length
    val count2 = Array.ofDim[Int](26)

    def check(): Boolean = {
      var i = 0
      while (i < 26 && count1(i) == count2(i)) {
        i += 1
      }
      i == 26
    }

    var i = 0
    var found = false
    while (i < n && !found) {
      count2(s2(i) - 'a') += 1

      if (i >= m - 1) {
        if (i >= m) {
          count2(s2(i - m) - 'a') -= 1
        }
        found = check()
      }

      i += 1
    }
    found
  }
}
