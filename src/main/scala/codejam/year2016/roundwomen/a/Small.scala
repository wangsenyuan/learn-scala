package codejam.year2016.roundwomen.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/13/16.
  */
object Small extends App {

  def play(nums: Vector[Long]): Vector[Long] = {
    def go(nums: Vector[Long], result: Vector[Long]): Vector[Long] = {
      if (nums.isEmpty) {
        result
      } else {
        val h = nums.head
        val tail = nums.tail
        val saleAt = tail.indexOf(h * 3 / 4)
        val prev = tail.take(saleAt)
        val next = tail.drop(saleAt + 1)
        go(prev ++ next, result :+ (h * 3 / 4))
      }
    }

    go(nums.reverse, Vector())
  }

  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val _ = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong).toVector
    val sales = play(nums).reverse
    println(s"Case #$i: ${sales.mkString(" ")}")
  }
}
