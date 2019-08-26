package set0000.set100.set130.p137

object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    val cnt = Array.fill(32)(0)

    for {
      num <- nums
      i <- 0 until 32
      if ((num >> i) & 1) == 1
    } {
      cnt(i) += 1
    }

    var res = 0
    for {
      i <- 0 until 32
      if cnt(i) % 3 == 1
    } {
      res |= 1 << i
    }
    res
  }
}
