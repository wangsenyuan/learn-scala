package set0000.set200.set200.p202

object Solution {

  def isHappy(n: Int): Boolean = {

    var slow = n.toLong
    var fast = n.toLong
    do {
      slow = digitSum(slow)
      fast = digitSum(digitSum(fast))
    } while (slow > 1 && slow != fast)

    slow == 1
  }

  private def digitSum(num: Long): Long = {
    var res = 0L
    var x = num
    while (x > 0) {
      val d = x % 10
      res += d * d
      x /= 10
    }
    res
  }
}
