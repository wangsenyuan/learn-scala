package set300.set370.p377

object Solution {

  import scala.collection.mutable
  import scala.util.Sorting

  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val n = nums.length
    val dp = Array.ofDim[Int](target + 1)
    dp(0) = 1

    for {
      cur <- 1 to target
      i <- 0 until n
      if (nums(i) <= cur)
    } {
      dp(cur) += dp(cur - nums(i))
    }

    dp(target)
  }


  def combinationSum42(nums: Array[Int], target: Int): Int = {
    Sorting.quickSort(nums)

    def go(div: Int, num: Int, n: Int, i: Int): Int = {
      if (num == 0) {
        fact(n) / div
      } else if (i == nums.length || nums(i) > num) {
        0
      } else {
        var res = 0
        var cnt = 0
        var f = 1
        while (cnt * nums(i) <= num) {
          res += go(div * f, num - cnt * nums(i), n + cnt, i + 1)
          cnt += 1
          f *= cnt
        }
        res
      }
    }

    go(1, target, 0, 0)
  }

  private def fact(n: Int): Int = {
    def go(n: Int, res: Int): Int = {
      if (n == 0) {
        res
      } else {
        go(n - 1, n * res)
      }
    }

    go(n, 1)
  }

  def combinationSum41(nums: Array[Int], target: Int): Int = {
    val cache = mutable.Map.empty[Int, Int]

    def go(num: Int): Int = {
      if (num == 0) {
        1
      } else {
        if (!cache.contains(num)) {
          var res = 0

          nums.filter(_ <= num).foreach(x => res += go(num - x))

          cache(num) = res
        }

        cache(num)
      }
    }

    go(target)
  }
}

