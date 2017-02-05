package codechef.easy.cbarg

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/31.
  */
object Main {

  def allocateMemory(ms: Array[Long]): Long =
    ms(0) + (ms.zip(ms.tail).filter(x => x._1 < x._2).map(x => x._2 - x._1).sum)

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val ms = StdIn.readLine().split("\\s+").map(_.toLong)

      val res = allocateMemory(ms)

      println(res)
      t -= 1
    }
  }
}
