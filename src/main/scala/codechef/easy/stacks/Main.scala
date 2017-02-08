package codechef.easy.stacks

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/02/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = makeStacks(nums)
      println(s"${res.length} ${res.mkString(" ")}")
      t -= 1
    }
  }

  def makeStacks(nums: Array[Int]) = {
    var idx = 0
    var i = 0
    val res = Array.fill(nums.length)(0)
    while (i < nums.length) {
      val j = search(idx, res(_) > nums(i))
      if (j < idx) {
        res(j) = nums(i)
      } else {
        res(idx) = nums(i)
        idx += 1
      }
      i += 1
    }

    res.take(idx)
  }

  def search(n: Int, f: Int => Boolean): Int = {
    var i = 0
    var j = n

    while (i < j) {
      val k = i + (j - i) / 2
      if (f(k)) {
        j = k
      } else {
        i = k + 1
      }
    }

    i
  }

}
