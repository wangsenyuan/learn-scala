package set1000.set1200.set1290.p1298

import scala.collection.mutable

object Solution {
  def maxCandies(status: Array[Int], candies: Array[Int], keys: Array[Array[Int]], containedBoxes: Array[Array[Int]], initialBoxes: Array[Int]): Int = {
    val que1 = mutable.Queue.empty[Int]
    val que2 = mutable.Queue.empty[Int]

    initialBoxes.foreach(box => {
      if (status(box) == 1) {
        que1.enqueue(box)
      } else {
        que2.enqueue(box)
      }
    })

    val n = status.length

    val hasKey = Array.ofDim[Boolean](n)

    var res = 0
    while (!que1.isEmpty) {
      val cur = que1.dequeue()
      res += candies(cur)

      containedBoxes(cur).foreach(box => {
        que2.enqueue(box)
      })

      keys(cur).foreach(box => {
        hasKey(box) = true
      })

      val m = que2.length

      var i = 0
      while (i < m) {
        val x = que2.dequeue()
        if (hasKey(x) || status(x) == 1) {
          que1.enqueue(x)
        } else {
          que2.enqueue(x)
        }
        i += 1
      }
    }

    res
  }
}
