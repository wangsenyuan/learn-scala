package set0000.set100.set150.p150

object Solution {
  def evalRPN(tokens: Array[String]): Int = {
    val n = tokens.length
    val stack = Array.fill(n)(0)
    var p = 0
    var i = 0
    while (i < n) {
      val tk = tokens(i)
      if (tk == "+") {
        val a = stack(p - 2)
        val b = stack(p - 1)
        stack(p - 2) = a + b
        p -= 1
      } else if (tk == "-") {
        val a = stack(p - 2)
        val b = stack(p - 1)
        stack(p - 2) = a - b
        p -= 1
      } else if (tk == "*") {
        val a = stack(p - 2)
        val b = stack(p - 1)
        stack(p - 2) = a * b
        p -= 1
      } else if (tk == "/") {
        val a = stack(p - 2)
        val b = stack(p - 1)
        stack(p - 2) = a / b
        p -= 1
      } else {
        stack(p) = tk.toInt
        p += 1
      }
      i += 1
    }
    stack(0)
  }
}
