package set0000.set400.set460.p466

object Solution {
  def getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int = {
    if(n1 == 0) {
      0
    } else {
      val indexr = Array.fill(s2.size + 2)(0)
      val countr = Array.fill(s2.size + 2)(0)
      var index = 0
      var count = 0
      for {
        i <- 1 to n1
      } {
        for {
          j <- s1.indices
        } {
          if(s1(j) == s2(index)) {
            index += 1
          }
          if(index == s2.size) {
            count += 1
            index = 0
          }
        }
        countr(i) = count
        indexr(i) = index
        for {
          k <- 1 until i
          if(indexr(k) == index)
        } {
          // find a repetition
          val prevCount = countr(k)
          val patternCount =  (n1 - k) / (i - k) * (countr(i) - countr(k))
          val remCount = countr(k + (n1 - k) % (i - k)) - countr(k)
          return (prevCount + patternCount + remCount) / n2
        }
      }
      countr(n1) / n2
    }
  }

}
