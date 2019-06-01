package set700.set720.p728

object Solution {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    (left to right).filter(isSelfDividing).toList
  }

  private def isSelfDividing(num: Int): Boolean = {
    var x = num
    while(x > 0) {
      val last = x % 10
      if(last == 0 || num % last != 0) {
        return false
      }
      x /= 10
    }
    true
  }
}
