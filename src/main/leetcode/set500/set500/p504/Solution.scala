package set500.set500.p504

object Solution {
  def convertToBase7(num: Int): String = {
    if(num == 0) {
      "0"
    } else {
      val res = new StringBuilder
      val neg = num < 0
      var tmp = num.abs
      while(tmp != 0) {
        res.append(tmp % 7)
        tmp /= 7
      }

      if(neg) {
        res.append("-")
      }

      res.reverse.toString()
    }
  }
}
