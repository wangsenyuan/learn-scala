package codechef.easy.lckyst

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/11.
  */
object Main {

  def factorCount(num: Long, fac: Long): Int = {
    var cnt = 0
    var tmp = num
    while (tmp % fac == 0) {
      cnt += 1
      tmp /= fac
    }

    cnt
  }

  def transform(num: Long) = {
    var x = factorCount(num, 2)

    val y = factorCount(num, 5)

    var tmp = num

    while (y > x) {
      tmp *= 4
      x += 2
    }

    tmp
  }


  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    var i = 0
    while (i < n) {
      val res = transform(nums(i))
      println(res)
      i += 1
    }
  }
}
