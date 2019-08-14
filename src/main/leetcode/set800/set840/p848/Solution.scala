package set800.set840.p848

object Solution {
  def shiftingLetters(S: String, shifts: Array[Int]): String = {
    val n = S.length

    var i = n - 1
    while(i >= 0) {
      if(i < n - 1) {
        shifts(i) += shifts(i+1)
      }
      shifts(i) %= 26
      i -= 1
    }

    val buf = new StringBuilder
    i = 0
    while(i < n) {
      val x = S(i) - 'a'
      val y = (x + shifts(i)) % 26
      buf.append((y + 'a').toChar)
      i += 1
    }
    buf.toString()
  }
}
