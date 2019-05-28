package set700.set710.p717

object Solution {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    val n = bits.length
    if(n == 1) {
      bits(0) == 0
    } else {
      var a = bits(0) == 0
      var b = bits(1) == 0 || bits(0) == 1

      var i = 2
      while(i < n) {
        var c = false
        if(bits(i) == 1) {
          if(i > 0 && bits(i-1) == 1) {
            c = a
          }
        } else if(bits(i) == 0) {
          c = b
          if(i > 0 && bits(i - 1) == 1) {
            c ||= a
          }
        }

        a = b
        b = c

        i += 1
      }

      a && b
    }
  }
}
