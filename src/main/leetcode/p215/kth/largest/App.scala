package p215.kth.largest

/**
 * Created by senyuanwang on 15/5/23.
 */
object App extends App {

  def qsort(list: List[Int], k: Int): Int =
    list match {
      case Nil => throw new Exception("should not get here")
      case h :: tail =>
        val (left, right) = tail.partition(_ > h)
        if (left.size == k - 1) {
          h
        } else if (left.size > k - 1) {
          qsort(left, k)
        } else {
          qsort(right, k - left.size - 1)
        }
    }

  def findKthLargest(nums: Array[Int], k: Int) = qsort(nums.toList, k)

  println(findKthLargest(Array(3, 3, 3, 3, 3, 3, 3, 3, 3), 8))
  println(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2))
}
