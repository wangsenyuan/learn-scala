package set700.set780.p786

object Solution {
  def kthSmallestPrimeFraction(A: Array[Int], K: Int): Array[Int] = {
    val n = A.length
    def count(x: Double): Int = {
      var i = 0
      var j = 0
      var cnt = 0
      while(i < n) {
        while(j < i && A(j) < A(i) * x) {
          j += 1
        }
        cnt += j
        i += 1
      }
      cnt
    }

    def findAnswer(x: Double): Array[Int] = {
      var i = 0
      var j = 0
      var max = 0.0
      val ans = Array(0, 0)
      while(i < n) {
        while(j < i && A(j) < A(i) * x) {
          j += 1
        }
        if(j > 0) {
          val f = A(j - 1).toDouble / A(i).toDouble
          if(f > max) {
            ans(0) = A(j-1)
            ans(1) = A(i)
            max = f
          }
        }
        i += 1
      }
      ans
    }

    var left = 0.0
    var right = 1.0

    while(left < right) {
      val mid = (left + right) / 2
      val cnt = count(mid)
      if(cnt == K) {
        return findAnswer(mid)
      } else if(cnt > K) {
        right = mid
      } else {
        left = mid
      }
    }
    return Array()
  }

}
