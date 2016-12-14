package codechef.march2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1

      StdIn.readLong()
      val leaves = StdIn.readLine().split("\\s+").map(_.toLong)
      if (count(leaves)) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }

  def count(leaves: Array[Long]): Boolean = {

    def go(i: Int, stemsFromPrevLevel: Long): Boolean = {
      if (i == leaves.length) {
        stemsFromPrevLevel == 0
      } else if (i < leaves.length - 1 && stemsFromPrevLevel == 0) {
        false
      } else if (leaves(i) > stemsFromPrevLevel) {
        false
      } else {
        go(i + 1, (stemsFromPrevLevel - leaves(i)) * 2)
      }
    }

    go(0, 1)
  }
}
