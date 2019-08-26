package set0000.set600.set650.p659

import scala.collection.mutable

object Solution {

  def isPossible(nums: Array[Int]): Boolean = {
    val n = nums.length
    val que = Array.ofDim[Int](n)
    var front = 0
    var end = 0
    var prev = Int.MinValue
    var prevCount = 0
    var anchor = 0
    var i = 0
    while(i < n) {
      val t = nums(i)
      if(i == n - 1 || nums(i + 1) != t) {
        if(prev > Int.MinValue && t - prev != 1) {
          while(prevCount > 0) {
            prevCount -= 1
            if(prev < que(front) + 2) {
              return false
            }
            front += 1
          }
          prev = Int.MinValue
        }
        val count = i - anchor + 1

        if(prev == Int.MinValue || t - prev == 1) {
          while(prevCount > count) {
            prevCount -= 1
            if(t - 1 < que(front) + 2) {
              return false
            }
            front += 1
          }
          while(prevCount < count) {
            prevCount += 1
            que(end) = t
            end += 1
          }
        }

        prev = t
        prevCount = count
        anchor = i + 1
      }

      i += 1
    }

    while(prevCount > 0) {
      prevCount -= 1
      if(nums(n - 1) < que(front) + 2) {
        return false
      }
      front += 1
    }
    return true
  }

  def isPossible1(nums: Array[Int]): Boolean = {
    val count = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val tail = mutable.Map.empty[Int, Int].withDefaultValue(0)

    nums.foreach(x => count(x) += 1)

    val n = nums.length

    def go(i: Int): Boolean = {
      if (i == n) {
        true
      } else {
        val x = nums(i)
        if (count(x) == 0) {
          go(i + 1)
        } else {
          if (tail(x) > 0) {
            tail(x) -= 1
            tail(x + 1) += 1
            count(x) -= 1
            go(i + 1)
          } else if (count(x + 1) > 0 && count(x + 2) > 0) {
            count(x) -= 1
            count(x + 1) -= 1
            count(x + 2) -= 1
            tail(x + 3) += 1
            go(i + 1)
          } else {
            false
          }
        }
      }
    }

    go(0)
  }
}
