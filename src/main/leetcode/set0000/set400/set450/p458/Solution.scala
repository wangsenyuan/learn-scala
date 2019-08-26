package set0000.set400.set450.p458

object Solution {
  def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
    if(buckets <= 1) {
      0
    } else if(minutesToDie > minutesToTest) {
      -1
    } else {
      var n = buckets - 1
      val base = minutesToTest / minutesToDie + 1
      var res = 0
      while(n > 0) {
        n /= base
        res += 1
      }
      res
    }
  }
}
