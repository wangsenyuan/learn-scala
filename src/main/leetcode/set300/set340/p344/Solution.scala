package set300.set340.p344

object Solution {
  def reverseString(s: Array[Char]): Unit = {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      val c = s(i)
      s(i) = s(j)
      s(j) = c
      i += 1
      j -= 1
    }
  }
}
