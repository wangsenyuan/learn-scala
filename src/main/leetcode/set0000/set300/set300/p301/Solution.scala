package set0000.set300.set300.p301

/**
  * Created by wangsenyuan on 24/10/2016.
  */
object Solution {

  def main(args: Array[String]): Unit = {
    removeInvalidParentheses("()())").foreach(println)
    removeInvalidParentheses(")(").foreach(println)
    removeInvalidParentheses("(a)())()").foreach(println)
    removeInvalidParentheses(")()(").foreach(println)
  }

  def removeInvalidParentheses(s: String): List[String] = {
    var left = 0
    var right = 0
    var i = 0
    while (i < s.length) {
      if (s(i) == '(') {
        left += 1
      } else if (s(i) == ')') {
        if (left > 0) {
          left -= 1
        } else {
          right += 1
        }
      }
      i += 1
    }

    def go(i: Int, left: Int, right: Int, leftRem: Int, rightRem: Int, res: String): List[String] = {
      if (i == s.length) {
        if (leftRem == 0 && rightRem == 0) {
          List(res + s.substring(i))
        } else {
          Nil
        }
      } else s(i) match {
        case '(' =>
          go(i + 1, left + 1, right, leftRem, rightRem, res + s(i)) ++
            go(i + 1, left, right, leftRem - 1, rightRem, res)
        case ')' =>
          var tmp = List.empty[String]
          if (right < left) {
            //only add ) where there are more (
            tmp ++= go(i + 1, left, right + 1, leftRem, rightRem, res + s(i))
          }
          if (rightRem > 0) {
            //try to skip this
            tmp ++= go(i + 1, left, right, leftRem, rightRem - 1, res)
          }
          tmp
        case _ =>
          go(i + 1, left, right, leftRem, rightRem, res + s(i))
      }
    }

    val res = go(0, 0, 0, left, right, "")
    res.distinct
  }
}
