package set400.set470.p479

import scala.collection.mutable

object Solution {
  private def longMul(x: (Int, Int)): Long = x._1.toLong * x._2.toLong

  private def isPalindrome(num: Long): Boolean = {
    var rev = 0L
    var cur = num
    while(cur > 0) {
      rev = rev * 10 + cur % 10
      cur /= 10
    }
    rev == num
  }

  def largestPalindrome(n: Int): Int = {
    val max = Math.pow(10, n).toInt - 1
    val min = max - Math.pow(10, (n + 1) / 2).toInt

    val pq = mutable.PriorityQueue[(Int, Int)]()(new Ordering[(Int, Int)]() {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = {
        val a = longMul(x)
        val b = longMul(y)

        if (a < b) {
          -1
        } else if (a > b) {
          1
        } else {
          0
        }
      }
    })

    for {
      i <- max until min by -1
      r = i % 10
    } {
      if (r == 3 || r == 7) {
        pq.enqueue(i -> i)
      } else if(r == 1) {
        pq.enqueue(i -> (i - 2))
      } else if(r == 9) {
        pq.enqueue(i -> (i - 8))
      }
    }

    while(!pq.isEmpty) {
      val (a, b) = pq.dequeue()
      val x = longMul(a -> b)
      if(isPalindrome(x)) {
        return (x % 1337).toInt
      }
      if(b > min) {
        pq.enqueue(a -> (b - 10))
      }
    }
    0
  }

  def largestPalindrome1(n: Int): Int = {
    val max = Math.pow(10, n).toLong - 1
    val min = max / 10

    for {
      h <- max until min by -1
    } {
      var left = h
      var right = 0L

      var i = h
      while (i > 0) {
        right = right * 10 + i % 10
        left *= 10
        i /= 10
      }

      val p = left + right
      var x = max
      while (x > min && p / x <= x) {
        if (p % x == 0) {
          return (p % 1337).toInt
        }
        x -= 1
      }
    }
    9
  }
}
