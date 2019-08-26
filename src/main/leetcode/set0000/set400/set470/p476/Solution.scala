package set0000.set400.set470.p476

object Solution {
  def findComplement(num: Int): Int = {
    if(num == 0) {
      1
    } else {
      var i = 0
      var cur = 1L
      var res = 0
      while(cur <= num) {
        if((num >> i & 1) == 0) {
          res |= 1 << i
        }
        cur <<= 1
        i += 1
      }
      res
    }
  }
}
