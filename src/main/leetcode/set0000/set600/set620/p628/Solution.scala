package set0000.set600.set620.p628

object Solution {
  def maximumProduct(nums: Array[Int]): Int = {
    val n = nums.length

    if (n <= 6) {
      val res = for {
        i <- 0 until n
        j <- i + 1 until n
        k <- j + 1 until n
      } yield nums(i) * nums(j) * nums(k)
      res.max
    } else {

      val dp = Array.fill(3)(Int.MinValue)

      val fp = Array.fill(3)(Int.MaxValue)

      nums.foreach(num => {
        if (num >= dp(0)) {
          dp(2) = dp(1)
          dp(1) = dp(0)
          dp(0) = num
        } else if (num >= dp(1)) {
          dp(2) = dp(1)
          dp(1) = num
        } else if (num >= dp(2)) {
          dp(2) = num
        }

        if (num <= fp(0)) {
          fp(2) = fp(1)
          fp(1) = fp(0)
          fp(0) = num
        } else if (num <= fp(1)) {
          fp(2) = fp(1)
          fp(1) = num
        } else if (num <= fp(2)) {
          fp(2) = num
        }
      })

      val res1 = dp(0) * fp(0) * fp(1)
      val res2 = dp(0) * dp(1) * dp(2)
      res1 max res2
    }
  }
}
