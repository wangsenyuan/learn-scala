package set000.set070.p077

import scala.collection.mutable.ListBuffer

object Solution {
  def combine(n: Int, k: Int): List[List[Int]] = {
    //n would be small
    val res = ListBuffer.empty[List[Int]]


    def go(lst: List[Int], start: Int): Unit = {
      if (lst.size == k) {
        res += lst.reverse
      } else {
        for {
          x <- (start + 1) to n
        } {
          go(x :: lst, x)
        }
      }
    }

    go(Nil, 0)

    res.toList
  }
}
