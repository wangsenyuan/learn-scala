package p349.arrays.intersection

/**
  * Created by wangsenyuan on 5/18/16.
  */
object Solution {

  def intersectionOfSortArrays(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    def indexOfNums2Ge(t: Int, j: Int): Int = {
      if (nums2(j) >= t) {
        j
      } else {
        indexOfNums2Ge(t, j + 1)
      }
    }

    def go(i: Int, j: Int, result: List[Int]): List[Int] = {
      if (i == nums1.length) {
        result
      } else if (i > 0 && nums1(i) == nums1(i - 1)) {
        go(i + 1, j, result)
      } else {
        val k = indexOfNums2Ge(nums1(i), j)
        if (k == nums2.length) {
          result
        } else if (nums2(k) > nums1(i)) {
          go(i + 1, k, result)
        } else {
          go(i + 1, k + 1, nums1(i) :: result)
        }
      }
    }
    go(0, 0, Nil).toArray
  }

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    intersectionOfSortArrays(nums1.sorted, nums2.sorted)
  }

  def main(args: Array[String]): Unit = {
    val nums1 = Array(9, 4, 5)
    val nums2 = Array(9, 8, 9, 4, 8)
    val result = intersection(nums1, nums2)
    println(result.mkString(" "))
  }
}
