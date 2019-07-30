package set800.set820.p822

object Solution {
  def flipgame(fronts: Array[Int], backs: Array[Int]): Int = {
    val m = fronts.max max backs.max
    val flags = Array.ofDim[Boolean](m + 1)
    val has = Array.ofDim[Boolean](m + 1)
    val n = fronts.length

    var i = 0
    while(i < n) {
      val a = fronts(i)
      val b = backs(i)

      if(a == b) {
        flags(a) = true
      }
      has(a) = true
      has(b) = true
      i += 1
    }

    var num = 1
    while(num <= m && (!has(num) || flags(num))) {
      num += 1
    }

    if(num > m) {
      0
    } else {
      num
    }
  }
}
