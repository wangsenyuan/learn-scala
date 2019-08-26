package set0000.set500.set500.p505

object Solution {
  def findRelativeRanks(nums: Array[Int]): Array[String] = {
    val arr = nums.zipWithIndex.sortBy(_._1).reverse
    val n = nums.length
    val res = Array.fill(n)("")
    for {
      i <- arr.indices
    } {
      val j = arr(i)._2
      if(i == 0) {
        res(j) = "Gold Medal"
      } else if(i == 1) {
        res(j) = "Silver Medal"
      } else if(i == 2) {
        res(j) = "Bronze Medal"
      } else {
        res(j) = s"${i + 1}"
      }
    }
    res
  }
}
