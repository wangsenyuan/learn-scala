package set0000.set500.set550.p553

object Solution {
  def optimalDivision(nums: Array[Int]): String = {
    val n = nums.length
    if (n == 1) {
      s"${nums(0)}"
    } else if (n == 2) {
      s"${nums(0)}/${nums(1)}"
    } else {
      val first = nums.head
      val res = nums.tail.mkString("/");
      s"${first}/(${res})"
    }
  }
}
