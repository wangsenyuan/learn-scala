package set000.set070.p078

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) {
      List(Nil)
    } else {
      val head = nums.head
      val res = subsets(nums.tail)
      val ans = res.map(head :: _)
      res ++ ans
    }
  }
}
