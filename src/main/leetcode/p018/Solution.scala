package p018

/**
  * Created by wangsenyuan on 6/30/16.
  */
object Solution extends App {

  private def twoSum(nums: Vector[Int], target: Int): Vector[Vector[Int]] = {
    def go(i: Int, j: Int, result: Vector[Vector[Int]]): Vector[Vector[Int]] = {
      if (i >= j) {
        result
      } else if (i > 0 && nums(i) == nums(i - 1)) {
        go(i + 1, j, result)
      } else if (j < nums.size - 1 && nums(j) == nums(j + 1)) {
        go(i, j - 1, result)
      } else {
        val sum = nums(i) + nums(j)
        if (sum > target) {
          go(i, j - 1, result)
        } else if (sum < target) {
          go(i + 1, j, result)
        } else {
          go(i + 1, j - 1, result :+ Vector(nums(i), nums(j)))
        }
      }
    }

    go(0, nums.size - 1, Vector())
  }

  private def threeSum(nums: Vector[Int], target: Int): Vector[Vector[Int]] = {
    def go(i: Int, result: Vector[Vector[Int]]): Vector[Vector[Int]] = {
      if (i <= 1) {
        result
      } else if (i < nums.size - 1 && nums(i) == nums(i + 1)) {
        go(i - 1, result)
      } else {
        val sub = twoSum(nums.take(i), target - nums(i))
        go(i - 1, result ++ sub.map(x => nums(i) +: x))
      }
    }
    go(nums.length - 1, Vector())
  }

  private def fourSum(nums: Vector[Int], target: Int): Vector[Vector[Int]] = {
    def go(i: Int, result: Vector[Vector[Int]]): Vector[Vector[Int]] = {
      if (i <= 2) {
        result
      } else if (i < nums.size - 1 && nums(i) == nums(i + 1)) {
        go(i - 1, result)
      } else {
        val sub = threeSum(nums.take(i), target - nums(i))
        go(i - 1, result ++ sub.map(x => nums(i) +: x))
      }
    }
    go(nums.length - 1, Vector())
  }

  def fourSum(nums: Array[Int], target: Int): Array[Array[Int]] = {
    fourSum(nums.sorted.toVector, target).map(_.toArray).toArray
  }

  fourSum(Array(1, 0, -1, 0, -2, 2), 0).foreach(x => println(x.mkString(" ")))
}
