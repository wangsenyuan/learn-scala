package codechef.littleelephantandpermutations

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/15/16.
  */
object Main {


  def notPerfect(nums: Vector[Int]): Boolean = {
    var i = 0
    while (i < nums.size) {
      var j = i + 2
      while (j < nums.size) {
        if (nums(i) > nums(j)) {
          return true
        }
        j += 1
      }
      i += 1
    }
    false
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val line = StdIn.readLine()
      val nums = line.split("\\s+").map(_.toInt).toVector

      val r = notPerfect(nums)
      if (r) {
        println("NO")
      } else {
        println("YES")
      }
      t -= 1
    }
  }
}
