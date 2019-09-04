package set0000.set900.set910.p911


object Solution {

  import java.util

  import scala.util.Sorting

  class TopVotedCandidate(_persons: Array[Int], _times: Array[Int]) {
    val votes = _persons.zip(_times)

    // according time
    Sorting.quickSort(votes)(Ordering.by(_._2))

    val n = _persons.length
    val pq = Array.ofDim[Int](n)
    var sz = 0

    val cnts = Array.ofDim[Int](n + 1)

    val pos = Array.fill(n + 1)(-1)
    val arr = Array.fill(n)(-1)

    private def update(person: Int, index: Int, cnt: Int): Unit = {
      var i = index
      if (i < 0) {
        // put it at the last position
        i = sz
        sz += 1
      }
      var stop = false
      // try swim up
      while (i > 0 && !stop) {
        val p = i >> 1

        if (cnts(arr(p)) > cnt) {
          stop = true
        } else {
          pos(arr(p)) = i
          arr(i) = arr(p)

          i = p
        }
      }

      pos(person) = i
      arr(i) = person
      // try swim down
      stop = false
      while (i * 2 + 1 < sz && !stop) {
        var child = i * 2 + 1
        if (child + 1 < sz && cnts(arr(child)) < cnts(arr(child + 1))) {
          // right has more votes
          child += 1
        }
        if (cnts(arr(child)) <= cnt) {
          stop = true
        } else {
          pos(arr(child)) = i
          arr(i) = arr(child)
          i = child
        }
      }

      if (i != pos(person)) {
        pos(person) = i
        arr(i) = person
      }
    }

    val ans = new util.TreeMap[Int, Int]()

    var i = 0
    while (i < n) {
      val vote = votes(i)

      val p = vote._1
      val t = vote._2

      cnts(p) += 1

      update(p, pos(p), cnts(p))

      ans.put(t, arr(0))

      i += 1
    }


    def q(t: Int): Int = {
      ans.floorEntry(t).getValue
    }

  }

  /**
   * Your TopVotedCandidate object will be instantiated and called as such:
   * var obj = new TopVotedCandidate(persons, times)
   * var param_1 = obj.q(t)
   */
}
