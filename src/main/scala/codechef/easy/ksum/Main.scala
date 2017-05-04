package codechef.easy.ksum

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/4.
  */
object Main {

  case class Item(sum: Long, left: Int, right: Int)

  implicit val itemOrdering = new Ordering[Item] {
    override def compare(x: Item, y: Item): Int = {
      if (x.sum < y.sum) {
        -1
      } else if (x.sum > y.sum) {
        1
      } else {
        0
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)
    val sum = nums.sum
    val pq = mutable.PriorityQueue.empty[Item]

    val res = new mutable.StringBuilder()

    pq.enqueue(Item(sum, 0, n - 1))

    var i = 0
    while (i < k && !pq.isEmpty) {
      val cur = pq.dequeue()
      res.append(cur.sum).append(" ")
      val x = cur.sum
      val l = cur.left
      val r = cur.right
      if (l != r) {
        pq.enqueue(Item(x - nums(l), l + 1, r))
        pq.enqueue(Item(x - nums(r), l, r - 1))
      }

      i += 1
    }

    res.setLength(res.length - 1)

    println(res.toString())
  }


}
