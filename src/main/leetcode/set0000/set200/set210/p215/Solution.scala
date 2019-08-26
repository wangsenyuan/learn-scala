package set0000.set200.set210.p215


object Solution {

  import scala.util.Sorting

  def findKthLargest(nums: Array[Int], k: Int): Int = {
    Sorting.quickSort(nums)
    nums(nums.length - k)
  }

  def findKthLargest1(nums: Array[Int], k: Int): Int = {
    def qsort(nums: Array[Int], k: Int): Int = {
      if (nums.size == 1) {
        nums(0)
      } else {
        val h = nums.head
        val t = nums.tail
        val (gt, rst) = t.partition(_ > h)
        if (gt.size == k - 1) {
          h
        } else if (gt.size > k - 1) {
          qsort(gt, k)
        } else {
          qsort(rst, k - 1 - gt.size)
        }
      }
    }

    qsort(nums, k)
  }
}
