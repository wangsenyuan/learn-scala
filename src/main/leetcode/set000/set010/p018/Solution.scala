package set000.set010.p018

import scala.collection.mutable.ListBuffer

/**
  * Created by wangsenyuan on 6/30/16.
  */
object Solution {

  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    if (nums == null || nums.length == 0) {
      Nil
    } else {
      four(nums.sorted, target)
    }
  }

  private def four(nums: Array[Int], target: Int): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]
    var i = 0
    while (i + 3 < nums.size) {
      if (i == 0 || nums(i) > nums(i - 1)) {
        val sub = three(nums, i + 1, target - nums(i))
        res ++= sub.map(item => nums(i) :: item)
      }

      i += 1
    }
    res.toList
  }

  private def three(nums: Array[Int], start: Int, target: Int): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]

    var i = start
    while (i + 2 < nums.size) {
      if (i == start || nums(i) > nums(i - 1)) {
        val sub = two(nums, i + 1, target - nums(i))
        res ++= sub.map(item => nums(i) :: item)
      }
      i += 1
    }

    res.toList
  }

  private def two(nums: Array[Int], start: Int, target: Int): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]
    var i = start
    var j = nums.length - 1
    while (i < j) {
      if (i > start && nums(i) == nums(i - 1)) {
        i += 1
      } else if (j < nums.length - 1 && nums(j) == nums(j + 1)) {
        j -= 1
      } else {
        val sum = nums(i) + nums(j)
        if (sum > target) {
          j -= 1
        } else if (sum < target) {
          i += 1
        } else {
          res += List(nums(i), nums(j))
          i += 1
          j -= 1
        }
      }
    }

    res.toList
  }
}
