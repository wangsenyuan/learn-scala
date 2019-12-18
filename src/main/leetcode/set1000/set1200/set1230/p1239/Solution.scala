package set1000.set1200.set1230.p1239

object Solution {
  def maxLength(lst: List[String]): Int = {
    val arr = lst.filterNot(hasDuplicate).toArray
    val masks = arr.map(toMask)
    val n = arr.length

    val N = 1 << n

    var best = 0
    var state = 1
    while (state < N) {
      var mask = 0
      var len = 0
      var can = true
      var i = 0
      while (i < n && can) {
        if ((state & (1 << i)) > 0) {
          if ((mask & masks(i)) > 0) {
            can = false
          } else {
            len += arr(i).length
            mask |= masks(i)
          }
        }
        i += 1
      }

      if (can) {
        best = best max len
      }

      state += 1
    }

    best
  }

  private def toMask(s: String): Int = {
    var res = 0
    var i = 0
    while (i < s.length) {
      val x = s(i) - 'a'
      res |= 1 << x
      i += 1
    }
    res
  }

  private def hasDuplicate(s: String): Boolean = {
    var res = 0
    var i = 0
    while (i < s.length) {
      val x = s(i) - 'a'
      if ((res & (1 << x)) > 0) {
        return true
      }
      res |= 1 << x
      i += 1
    }
    false
  }
}
