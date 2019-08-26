package set0000.set500.set560.p564

object Solution {

  def mirror(s: String): String = {
    val n = s.length
    val cs = s.toCharArray
    var i = 0
    var j = n - 1
    while(i < j) {
      cs(j) = cs(i)
      i += 1
      j -= 1
    }
    new String(cs)
  }

  private def difference(a: String, b: String) = (a.toLong - b.toLong).abs

  private def decrement(s: String): String = {
    val n = s.length
    val cs = s.toCharArray
    var i = (n - 1) / 2
    while(i >= 0 && cs(i) == '0') {
      cs(i) = '9'
      i -= 1
    }
    if(i == 0 && cs(i) == '1') {
      // need to remove first 1
      cs(n / 2) = '9'
      val x = new String(cs, 1, n - 1)
      mirror(x)
    } else {
      cs(i) = (cs(i) - 1).toChar
      val x = new String(cs)
      mirror(x)
    }
  }

  private def increment(s: String): String = {
    val n = s.length
    val cs = s.toCharArray
    var i = (n - 1) / 2

    while(i >= 0 && cs(i) == '9') {
      cs(i) = '0'
      i -= 1
    }
    if(i < 0) {
      val x = '1' + new String(cs)
      mirror(x)
    } else {
      cs(i) = (cs(i) + 1).toChar
      val x = new String(cs)
      mirror(x)
    }
  }

  def nearestPalindromic(s: String): String = {
    if(s == "1") {
      "0"
    } else {
      val n = s.length
      val a = mirror(s)
      var diff0 = difference(s, a)
      if(diff0 == 0) {
        diff0 = Long.MaxValue
      }

      val b = decrement(s)
      val diff1 = difference(s, b)

      val c = increment(s)
      val diff2 = difference(s, c)

      if(diff1 <= diff0 && diff1 <= diff2) {
        b
      } else if(diff0 <= diff1 && diff0 <= diff2) {
        a
      } else {
        c
      }
    }
  }
}
