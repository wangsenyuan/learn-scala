package set000.set060.p067

object Solution {

  def addBinary(a: String, b: String): String = {
    val n = a.length max b.length
    val aa = normalize(a, n).map(x => if (x == '0') 0 else 1)
    val bb = normalize(b, n).map(x => if (x == '0') 0 else 1)
    val cc = aa.zip(bb).map(x => x._1 + x._2).toArray
    var i = n - 1
    while (i > 0) {
      cc(i - 1) += cc(i) / 2
      cc(i) %= 2
      i -= 1
    }
    if (cc(0) > 1) {
      cc(0) %= 2
      (1 +: cc).mkString("")
    } else {
      cc.mkString("")
    }
  }

  private def normalize(str: String, n: Int): String = {
    if (str.length == n) {
      str
    } else {
      "0" * (n - str.length) + str
    }
  }
}
