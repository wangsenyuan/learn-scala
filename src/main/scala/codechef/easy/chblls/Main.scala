package codechef.easy.chblls

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/04/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    println(1)
    println("3 1 2 2")
    println("3 3 3 4")
    val diff = StdIn.readInt()

    println(2)
    if (diff == 0) {
      println(5)
    } else if (diff == 1) {
      println(1)
    } else if (diff == -1) {
      println(4)
    } else if (diff == 2) {
      println(2)
    } else {
      println(3)
    }
  }
}
