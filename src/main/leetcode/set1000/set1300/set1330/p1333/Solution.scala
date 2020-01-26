package set1000.set1300.set1330.p1333

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def filterRestaurants(restaurants: Array[Array[Int]], veganFriendly: Int, maxPrice: Int, maxDistance: Int): List[Int] = {
    val buf = ArrayBuffer.empty[Array[Int]]

    var i = 0
    while (i < restaurants.length) {
      val cur = restaurants(i)
      if (veganFriendly == 0 || cur(2) == 1) {
        if (cur(2) <= maxPrice && cur(3) <= maxDistance) {
          buf += cur
        }
      }

      i += 1
    }

    val res = buf.toArray

    Sorting.quickSort(res)(Ordering.fromLessThan((a, b) => {
      if (a(1) > b(1)) {
        true
      } else if (a(1) == b(1)) {
        a(0) > b(0)
      } else {
        false
      }
    }))

    res.map(_ (0)).toList
  }
}
