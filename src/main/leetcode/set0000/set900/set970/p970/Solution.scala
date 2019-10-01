package set0000.set900.set970.p970

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def powerfulIntegers(x: Int, y: Int, bound: Int): List[Int] = {
    if (x > y) {
      powerfulIntegers(y, x, bound)
    } else if (x == 1) {
      if (y == 1) {
        if (bound >= 2) {
          List(2)
        } else {
          List()
        }
      } else {
        val ys = powerUntil(y, bound)
        ys.map(_ + 1).filter(_ <= bound)
      }
    } else {
      val set = mutable.Set.empty[Int]
      val xs = powerUntil(x, bound)
      val ys = powerUntil(y, bound)
      val buf = ListBuffer.empty[Int]
      for {
        x <- xs
        y <- ys
        if x + y <= bound
        if !set(x + y)
      } {
        buf += (x + y)
        set += (x + y)
      }

      buf.toList
    }

  }

  private def powerUntil(x: Int, bound: Int): List[Int] = {
    val buf = ListBuffer.empty[Int]
    var r = 1
    while (r <= bound) {
      buf += r
      r *= x
    }
    buf.toList
  }

}
