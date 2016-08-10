package codechef.payingup

/**
  * Created by senyuanwang on 16/8/10.
  */
object Main {

  def main(args: Array[String]): Unit = {

  }

  def play(m: Int, nums: Array[Int]): Boolean = {
    val sorted = nums.sorted
    val n = nums.length
    val sums = Array.fill(n + 1)(0)

    var i = 0
    while (i < n) {
      sums(i + 1) = sums(i) + nums(i)
      i += 1
    }

    def doPlay(i: Int, left: Int): Boolean = {
      if (left == 0 || left == sums(n) - sums(i)) {
        true
      } else if (left < sorted(i)) {
        false
      } else if (left > sums(n) - sums(i)) {
        false
      } else {
        doPlay(i + 1, left - sorted(i)) || doPlay(i + 1, left)
      }
    }

    if (m == 0) {
      false
    } else {
      doPlay(0, m)
    }
  }
}
