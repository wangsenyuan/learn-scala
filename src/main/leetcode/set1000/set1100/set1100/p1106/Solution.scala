package set1000.set1100.set1100.p1106

object Solution {
  def parseBoolExpr(expression: String): Boolean = {
    val n = expression.length
    val pp = Array.ofDim[Int](n)
    val stack = Array.ofDim[Int](n)
    var p = 0
    for {
      i <- 0 until n
    } {
      if (expression(i) == '(') {
        stack(p) = i
        p += 1
      } else if (expression(i) == ')') {
        pp(stack(p - 1)) = i
        p -= 1
      }
    }

    def and(start: Int, end: Int): Boolean = {
      var res = true
      var j = start
      var i = start
      while (res && i <= end) {
        if (i == end || expression.charAt(i) == ',') {
          if (i > j) {
            res = eval(j, i)
          }
          i += 1
          j = i
        } else if (expression.charAt(i) == '(') {
          i = pp(i) + 1
        } else {
          i += 1
        }
      }

      res
    }

    def or(start: Int, end: Int): Boolean = {
      var res = false
      var j = start
      var i = start
      while (!res && i <= end) {
        if (i == end || expression.charAt(i) == ',') {
          if (i > j) {
            res = eval(j, i)
          }
          i += 1
          j = i
        } else if (expression.charAt(i) == '(') {
          i = pp(i) + 1
        } else {
          i += 1
        }
      }

      res
    }

    def eval(start: Int, end: Int): Boolean = {
      // expr will not be empty
      val h = expression.charAt(start)
      if (h == '!') {
        !eval(start + 1, end)
      } else if (h == '&') {
        and(start + 2, end - 1)
      } else if (h == '|') {
        or(start + 2, end - 1)
      } else if (h == '(') {
        eval(start + 1, end - 1)
      } else {
        // only one letter
        h == 't'
      }
    }

    eval(0, n)
  }


}
