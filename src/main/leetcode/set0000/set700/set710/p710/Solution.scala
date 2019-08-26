package set0000.set700.set710.p710

import scala.collection.mutable
import scala.util.{Random, Sorting}

class Solution(_N: Int, _blacklist: Array[Int]) {
  val m = _blacklist.size
  val n = _N - m
  val ii = mutable.Map.empty[Int, Int].withDefault(i => i)
  Sorting.quickSort(_blacklist)
  var i = _N - 1

  var j = m - 1
  while (j >= 0) {
    ii(_blacklist(j)) = ii(i)
    i -= 1
    j -= 1
  }

  val rand = new Random()

  def pick(): Int = {
    val k = rand.nextInt(n)
    if (ii.contains(k)) {
      ii(k)
    } else {
      k
    }
  }

}
