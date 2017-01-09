package codechef.easy.veryeasy

/**
  * Created by wangsenyuan on 8/11/16.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val nums = Array(137, 1315, 73, 136, 255, 1384, 16385)
    nums.foreach(num => println(play(num)))
  }


  def lastPow2(num: Int): Int = {
    var x = num
    var y = 1
    while (x > 1) {
      x /= 2
      y *= 2
    }
    return y
  }

  def split(num: Int): List[Int] = {
    if (num <= 2) {
      return List(num)
    } else {
      val x = lastPow2(num)
      if (x == num) {
        List(x)
      } else {
        x :: split(num - x)
      }
    }
  }

  def powOf(num: Int): Int = {
    var x = num
    var y = 0
    while (x > 1) {
      x /= 2
      y += 1
    }
    y
  }

  def play(num: Int): String = {
    def go(num: Int): String =
      split(num).map {
        case 1 => "2(0)"
        case 2 => "2"
        case x => "2(" + go(powOf(x)) + ")"
      }.mkString("+")

    s"${num}=${go(num)}"
  }

}
