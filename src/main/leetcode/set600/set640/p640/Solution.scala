package set600.set640.p640

object Solution {
  def solveEquation(equation: String): String = {
    val ss = equation.split("=")
    val left = parse(ss(0))
    val right = parse(ss(1))

    if (left.coefficient == 0 && right.coefficient == 0) {
      if (left.constant == right.constant) {
        "Infinite solutions"
      } else {
        "No solution"
      }
    } else {
      val coe = left.coefficient - right.coefficient
      val con = right.constant - left.constant

      if (coe == 0) {
        if (con != 0) {
          "No solution"
        } else {
          "Infinite solutions"
        }
      } else {
        s"x=${con / coe}"
      }
    }
  }

  class Expr(val coefficient: Int, val constant: Int) {
    def addConstant(num: Int): Expr = new Expr(this.coefficient, this.constant + num)

    def addCoefficient(num: Int): Expr = new Expr(this.coefficient + num, constant)
  }

  private def parse(s: String): Expr = {
    if (s(0) != '-' && s(0) != '+') {
      parse("+" + s)
    } else {
      var res = new Expr(0, 0)
      var i = 0

      while (i < s.length) {
        val sign =
          if (s(i) == '+') {
            1
          } else {
            -1
          }

        var j = i + 1
        var num = 0
        while (j < s.length && s(j).isDigit) {
          num = num * 10 + (s(j) - '0')
          j += 1
        }
        if (j < s.length && s(j) == 'x') {
          if (num == 0 && (s(j - 1) == '+' || s(j - 1) == '-')) {
            num = 1
          }
          res = res.addCoefficient(sign * num)
          j += 1
        } else {
          res = res.addConstant(sign * num)
        }

        i = j
      }
      res
    }
  }
}
