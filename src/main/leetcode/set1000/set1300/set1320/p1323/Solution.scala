package set1000.set1300.set1320.p1323

object Solution {
  def maximum69Number(num: Int): Int = {
    val s = num.toString.toCharArray

    var i = 0
    while (i < s.length && s(i) == '9') {
      i += 1
    }

    if (i == s.length) {
      num
    } else {
      s(i) = '9'
      s.mkString("").toInt
    }
  }
}
