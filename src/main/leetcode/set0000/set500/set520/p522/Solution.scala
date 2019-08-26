package set0000.set500.set520.p522

object Solution {
  def findLUSlength(strs: Array[String]): Int = {
    val n = strs.length
    if(n <= 1) {
      0
    } else {
      def check(i: Int): Boolean = {
        var can = true
        var j = 0
        while(j < n && can) {
          if(j != i && contains(strs(j), strs(i))) {
            can = false
          }
          j += 1
        }
        can
      }

      var len = -1
      var i = 0
      while(i < n) {
        if(check(i)) {
          if(strs(i).length > len) {
            len = strs(i).length
          }
        }
        i += 1
      }

      len
    }
  }

  private def contains(a: String, b: String): Boolean = {
    var i = 0
    var j = 0
    while(j < b.length) {
      while(i < a.length && a(i) != b(j)) {
        i += 1
      }
      if(i == a.length) {
        return false
      }
      i += 1
      j += 1
    }
    return true
  }
}
