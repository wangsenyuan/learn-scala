package set0000.set700.set770.p777

object Solution {
  def canTransform(start: String, end: String): Boolean = {
    var r = 0
    var l = 0
    var i = 0
    while(i < start.length) {
      if(start(i) == 'R') {
        r += 1
      } else if(start(i) == 'L') {
        l -= 1
      }
      if(end(i) == 'R') {
        r -= 1
      } else if(end(i) == 'L') {
        l += 1
      }
      if(r < 0 || l < 0) {
        return false
      }

      if(r > 0 && l > 0) {
        return false
      }

      i += 1
    }
    r == 0 && l == 0
  }
}
