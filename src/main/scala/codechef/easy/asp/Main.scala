package codechef.easy.asp

import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      var flag = true
      var i = 2
      while (i < n && flag) {
        val a = nums(i - 2)
        val b = nums(i - 1)
        val c = nums(i)
        flag = !((c < b && c < a) || (a > b && a > c))
        i += 1
      }

      if (flag) {
        println("YES")
      } else {
        println("NO")
      }
      t -= 1
    }
  }
}
