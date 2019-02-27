package set300.set390.p395

object Solution {
  def longestSubstring(s: String, k: Int): Int = {
    var best = 0
    val n = s.length
    val cnt = Array.ofDim[Int](26)
    var h = 1
    while(h <= 26) {
      clear(cnt)
      var i = 0
      var j = 0
      var u = 0
      var v = 0
      while(j < n) {
        if(u <= h) {
          if(cnt(s(j) - 'a') == 0) {
            u += 1
          }
          cnt(s(j) - 'a') += 1
          if(cnt(s(j) - 'a') == k) {
            v += 1
          }
          j += 1
        } else {
          if(cnt(s(i) - 'a') == k) {
            v -= 1
          }
          cnt(s(i) - 'a') -=1
          if(cnt(s(i) - 'a') == 0) {
            u -= 1
          }
          i += 1
        }
        if(u == h && v == h) {
          best = best max (j - i)
        }
      }

      h += 1
    }

    best
  }

  private def clear(arr: Array[Int]): Unit = {
    var i = 0
    while(i < arr.length) {
      arr(i) = 0
      i+=1
    }
  }
}
