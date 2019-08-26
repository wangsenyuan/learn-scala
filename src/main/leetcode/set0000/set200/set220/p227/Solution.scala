package set0000.set200.set220.p227

object Solution {
  def calculate(s: String): Int = {
    val stack = Array.fill(3)(0)
    var p = 0
    val ops = Array.fill(2)(' ')
    var q = 0

    def addOnSub(i: Int): Unit = {
      while (q > 0) {
        stack(p - 2) = operate(stack(p - 2), stack(p - 1), ops(q - 1))
        p -= 1
        q -= 1
      }
      ops(q) = s(i)
      q += 1
    }

    def mulOrDiv(i: Int): Unit = {
      while (q > 0 && (ops(q - 1) == '*' || ops(q - 1) == '/')) {
        //ops(q-1) is * or /
        stack(p - 2) = operate(stack(p - 2), stack(p - 1), ops(q - 1))
        p -= 1
        q -= 1
      }
      ops(q) = s(i)
      q += 1
    }

    def skip(): Unit = {

    }

    val n = s.length
    var i = 0
    while (i < n) {
      s(i) match {
        case ' ' => skip()
        case '+' => addOnSub(i)
        case '-' => addOnSub(i)
        case '*' => mulOrDiv(i)
        case '/' => mulOrDiv(i)
        case _ =>
          var num = 0
          var j = i
          while (j < n && Character.isDigit(s(j))) {
            num = num * 10 + (s(j) - '0')
            j += 1
          }
          stack(p) = num
          p += 1
          i = j - 1
      }

      i += 1
    }

    while (q > 0) {
      stack(p - 2) = operate(stack(p - 2), stack(p - 1), ops(q - 1))
      p -= 1
      q -= 1
    }

    stack(0)
  }

  private def operate(a: Int, b: Int, c: Char): Int = {
    c match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => throw new UnsupportedOperationException();
    }
  }
}
