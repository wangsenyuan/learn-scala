package rotatearray

/**
 * Created by senyuanwang on 15/2/26.
 */
object App {

  def main(args: Array[String]): Unit = {

    val nums = Array(1, 2, 3, 4, 5, 6, 7)
    solve(nums, 3)

    println(nums.mkString(", "))
  }

  def solve(nums: Array[Int], k: Int): Unit =
    if (k > nums.length) {
      solve(nums, k % nums.length)
    } else {
      val lk = nums.length - k
      for {
        i <- 0 until lk
      } {
        val x = nums(i)
        var lastJ = i
        for {
          j <- i until nums.length by lk
          if (j + lk < nums.length)
        } {
          nums(j) = nums(j + lk)
          lastJ = j + lk
        }
        nums(lastJ) = x
      }
    }

}
