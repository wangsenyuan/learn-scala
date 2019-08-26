package set0000.set200.set210.p217

object Solution {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val set = nums.toSet
    set.size < nums.length
  }
}
