package set400.set410.p415

object Solution {
  def addStrings(num1: String, num2: String): String = {
    var i = num1.length - 1
    var j = num2.length - 1
    val res = new StringBuilder()
    var carry = 0
    while (i >= 0 && j >= 0) {
      val x = num1(i) - '0'
      val y = num2(j) - '0'
      val s = x + y + carry
      res.append(s % 10)
      carry = s / 10
      i -= 1
      j -= 1
    }

    while (i >= 0) {
      val x = num1(i) - '0'
      val s = x + carry
      res.append(s % 10)
      carry = s / 10
      i -= 1
    }

    while (j >= 0) {
      val y = num2(j) - '0'
      val s = y + carry
      res.append(s % 10)
      carry = s / 10
      j -= 1
    }

    if (carry > 0) {
      res.append(carry)
    }

    val s = res.toString().reverse
    i = 0
    while (i < s.length && s(i) == '0') {
      i += 1
    }

    if (s.length == i) {
      "0"
    } else {
      s.substring(i)
    }
  }
}
