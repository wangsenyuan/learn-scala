package set500.set510.p519

import scala.collection.mutable
import scala.util.Random

class Solution(_n_rows: Int, _n_cols: Int) {
  val rand = new Random()
  var size = _n_rows * _n_cols

  val pos = mutable.Map.empty[Int, Int].withDefault(k => k)

  reset()

  def flip(): Array[Int] = {
    val x = rand.nextInt(size)
    val y = pos(x)

    pos(x) = pos(size - 1)
    size -= 1

    Array(y / _n_cols, y % _n_cols)
  }

  def reset() {
    size = _n_rows * _n_cols
    pos.clear()
  }

}

