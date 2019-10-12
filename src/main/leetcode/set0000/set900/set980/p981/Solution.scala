package set0000.set900.set980.p981

object Solution {


  import scala.collection.mutable
  import scala.collection.mutable.ArrayBuffer


  class TimeMap() {

    case class Item(timestamp: Int, value: String)

    val mem = mutable.Map.empty[String, ArrayBuffer[Item]]

    /** Initialize your data structure here. */


    def set(key: String, value: String, timestamp: Int) {
      if (!mem.contains(key)) {
        mem += key -> ArrayBuffer.empty
      }

      mem(key) += Item(timestamp, value)
    }

    def get(key: String, timestamp: Int): String = {
      if (!mem.contains(key)) {
        ""
      } else {
        val items = mem(key)
        val i = search(items.length, items(_).timestamp > timestamp) - 1
        if (i >= 0) {
          items(i).value
        } else {
          ""
        }
      }
    }


    private def search(n: Int, fn: Int => Boolean): Int = {
      var left = 0
      var right = n
      while (left < right) {
        val mid = (left + right) / 2
        if (fn(mid)) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      right
    }
  }


}
