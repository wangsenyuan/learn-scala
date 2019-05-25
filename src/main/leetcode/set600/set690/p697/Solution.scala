package set600.set690.p697

import scala.collection.mutable

object Solution {
  def findShortestSubArray(nums: Array[Int]): Int = {
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    var best = 0
    nums.foreach(num => {
      cnt(num) += 1
      best = best max cnt(num)
    })

    val first = mutable.Map.empty[Int, Int]
    val last = mutable.Map.empty[Int, Int]
    var i = 0
    while(i < nums.length) {
      if(cnt(nums(i)) == best) {
        if(!first.contains(nums(i))) {
          first(nums(i)) = i
        }
        last(nums(i)) = i
      }
      i += 1
    }

    var ans = nums.length

    last.foreach {
      case (k, j) => {
        val i = first(k)
        ans = ans min (j - i + 1)
      }
    }
    ans
  }
}
