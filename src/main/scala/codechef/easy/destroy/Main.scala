package codechef.easy.destroy

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/02/2017.
  */
object Main {

  def destroy(nums: Array[Int], n: Int): Int = {
    val ng = nums.groupBy(identity).map(_._2.length)
    val que = new mutable.PriorityQueue[Int]()
    ng foreach (que.enqueue(_))

    var res = 0

    while (!que.isEmpty) {
      val v = que.dequeue()
      if (que.isEmpty) {
        res += v
      } else {
        val w = que.dequeue()
        res += 1
        if (v > 1) {
          que.enqueue(v - 1)
        }
        if (w > 1) {
          que.enqueue(w - 1)
        }
      }
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt)

        val res = destroy(nums, n)

        println(res)
    }
  }
}
