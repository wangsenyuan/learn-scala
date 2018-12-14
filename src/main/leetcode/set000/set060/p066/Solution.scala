package set000.set060.p066

object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val re = digits.reverse
    val n = re.length

    def go(i: Int, carry: Int, res: List[Int]): List[Int] = {
      if (i == n) {
        if (carry > 0) {
          carry :: res
        } else {
          res
        }
      } else {
        val sum = re(i) + carry
        go(i + 1, sum / 10, (sum % 10) :: res)
      }
    }

    go(0, 1, Nil).toArray
  }
}
