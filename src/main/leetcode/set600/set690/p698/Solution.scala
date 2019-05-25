package set600.set690.p698

object Solution {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    if(k == 1) {
      true
    } else {
      val sum = nums.sum
      if(sum % k != 0) {
        false
      } else {
        val n = nums.length
        val s = sum / k

        def find(used: Int, i: Int, x: Int): IndexedSeq[Int] = {
            if(x == s) {
              Vector(used)
            } else if(i == n || x > s) {
              Vector()
            } else {
              (i until n).filter(j => (used & (1 << j)) == 0).flatMap(j => find(used | (1 << j), j + 1, x + nums(j)))
            }
        }

        def dfs(used: Int, i: Int): Boolean = {
          if(i == k) {
            true
          } else {
            val ns = find(used, 0, 0)
            ns.exists(dfs(_, i + 1))
          }
        }

        dfs(0, 0)
      }
    }
  }
}
