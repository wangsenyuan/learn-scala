package set500.set500.p507

object Solution {
  def checkPerfectNumber(num: Int): Boolean = {
    if(num == 1) {
      false
    } else {
      val sq = Math.sqrt(num).toInt
      var sum = 1
      var x = 2
      while(x <= sq && sum <= num) {
        if(num % x == 0) {
          val y = num / x
          sum += x
          sum += y
        }
        x += 1
      }
      sum == num
    }
  }
}
