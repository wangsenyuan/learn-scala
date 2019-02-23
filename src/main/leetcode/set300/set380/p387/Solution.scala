package set300.set380.p387

object Solution {
  def firstUniqChar(s: String): Int = {
    val cnt = Array.ofDim[Int](26)
    var i = s.length - 1
    while (i >= 0) {
      val x = s(i) - 'a'
      cnt(x) += 1
      i -= 1
    }

    i = 0
    while (i < s.length && cnt(s(i) - 'a') > 1) {
      i += 1
    }

    if(i == s.length) {
      -1
    } else {
      i
    }
  }
}
