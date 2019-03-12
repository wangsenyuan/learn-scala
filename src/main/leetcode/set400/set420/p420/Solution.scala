package set400.set420.p420

import scala.collection.mutable.ArrayBuffer

object Solution {

  def isUpper(c: Char): Boolean = c >= 'A' && c <= 'Z'

  def isLower(c: Char): Boolean = c >= 'a' && c <= 'z'

  def isDigit(c: Char): Boolean = c >= '0' && c <= '9'


  def strongPasswordChecker(s: String): Int = {
    val types = Array.ofDim[Boolean](3)
    val n = s.length
    val reps = ArrayBuffer.empty[Int]

    var i = 0
    while(i < n) {
      var j = i
      while(j < n && s(j) == s(i)) {
        j += 1
      }

      if(j - i >= 3) {
        reps += j - i
      }

      if(isUpper(s(i))) {
        types(0) = true
      } else if(isLower(s(i))) {
        types(1)= true
      } else if(isDigit(s(i))) {
        types(2) = true
      }

      i = j
    }

    val rs = reps.toArray

    val work = Array.ofDim[Int](3)
    if(n < 6) {
      work(0) = 6 - n
    } else if(n <= 20) {
      for {
        r <- rs
      } {
        work(2) += r / 3
      }
    } else {
      work(1) = n - 20
      var allByDel = 0
      var tmp = 0
      for {
        r <- rs
      } {
        allByDel += r - 2
        tmp += r /3
      }
      if(work(1) < allByDel) {
        // need to replace instead of delete
        work(2) = (tmp - work(1)) max (allByDel - work(1) + 2) / 3
      }
    }

    var miss = 0
    for {
      i <- 0 until 3
      if(!types(i))
    } {
      miss += 1
    }

    work(0) + work(1) + (work(2) max (miss - work(0)))
  }

}
