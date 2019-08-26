package set0000.set600.set630.p633

/**
  * Created by senyuanwang on 2017/7/2.
  */
object Solution {

  def judgeSquareSum(c: Int): Boolean = {
    val x = math.sqrt(c)
    var a = 0
    var checked = false
    while (a <= x && !checked) {
      val b = math.sqrt(c - a * a).toInt
      checked = a * a + b * b == c
      a += 1
    }

    checked
  }

  def main(args: Array[String]): Unit = {
    println(judgeSquareSum(1))
    println(judgeSquareSum(3))
    println(judgeSquareSum(5))
  }
}
