package set1000.set1200.set1290.p1295

object Solution {
  def findNumbers(nums: Array[Int]): Int = {
    nums.count(evenDigits)
  }

  private def evenDigits(num: Int): Boolean = {
    num.toString.length % 2 == 0
  }
}
