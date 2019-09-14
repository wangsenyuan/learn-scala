package set0000.set900.set930.p933


object Solution {

  class RecentCounter() {
    val n = 3002
    val que = Array.ofDim[Int](n)
    var front = 0
    var end = 0

    def ping(t: Int): Int = {
      while (front != end && que(front) + 3000 < t) {
        front += 1
        if (front >= n) {
          front = 0
        }

      }
      que(end) = t
      end = (end + 1) % n

      if (front < end) {
        end - front
      } else {
        n - (front - end)
      }
    }

  }

  class RecentCounter1() {

    import java.util

    val tree = new util.TreeMap[Int, Int]()

    def ping(t: Int): Int = {
      var sub = tree.subMap(t - 3000, t)
      val res = sub.size()
      if (t - 3000 >= 0) {
        sub = tree.subMap(0, true, t - 3000, true)
        sub.clear()
      }
      tree.put(t, 1)
      res + 1
    }

  }

  /**
   * Your RecentCounter object will be instantiated and called as such:
   * var obj = new RecentCounter()
   * var param_1 = obj.ping(t)
   */
}
