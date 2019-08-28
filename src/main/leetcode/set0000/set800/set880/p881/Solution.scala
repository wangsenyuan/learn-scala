package set0000.set800.set880.p881

import java.util

import scala.util.Sorting

object Solution {
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    Sorting.quickSort(people)
    var ans = 0
    var i = 0
    var n = people.length - 1
    while (n >= i) {
      ans += 1
      if (i < n && people(i) + people(n) <= limit) {
        i += 1
      }
      n -= 1
    }
    ans
  }

  def numRescueBoats1(people: Array[Int], limit: Int): Int = {
    Sorting.quickSort(people)

    val cnt = new util.TreeMap[Int, Int]()

    people.foreach(p => {
      if (cnt.containsKey(p)) {
        cnt.put(p, cnt.get(p) + 1)
      } else {
        cnt.put(p, 1)
      }
    })

    val n = people.length

    var ans = 0
    var i = 0
    while (i < n && cnt.size() > 0) {
      val x = cnt.get(people(i))

      if (x > 0) {
        ans += 1
        val y = cnt.floorEntry(limit - people(i))

        if (y != null && y.getKey == people(i)) {
          if (x <= 2) {
            cnt.remove(people(i))
          } else {
            cnt.put(people(i), x - 2)
          }
        } else {
          if (y != null) {
            // y.key > x
            if (y.getValue == 1) {
              cnt.remove(y.getKey)
            } else {
              cnt.put(y.getKey, y.getValue - 1)
            }
          }

          if (x == 1) {
            cnt.remove(people(i))
          } else {
            cnt.put(people(i), x - 1)
          }
        }
      }

      i += 1
    }

    ans
  }

}
