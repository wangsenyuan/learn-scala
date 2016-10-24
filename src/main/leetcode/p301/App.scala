package p301

/**
  * Created by wangsenyuan on 24/10/2016.
  */
object App {

  def main(args: Array[String]): Unit = {
    removeInvalidParentheses("()())").foreach(println)
    removeInvalidParentheses(")(").foreach(println)
    removeInvalidParentheses("(a)())()").foreach(println)


  }

  def removeInvalidParentheses(s: String): Vector[String] = {


    def remove(s: String, left: Char, right: Char, x: Int, y: Int): Vector[String] = {
      def go(i: Int, level: Int): Vector[String] =
        if (i == s.length) {
          if (left == ')') {
            Vector(s.reverse)
          } else {
            remove(s.reverse, right, left, 0, 0)
          }
        } else s(i) match {
          case `left` => go(i + 1, level + 1)
          case `right` if level > 0 => go(i + 1, level - 1)
          case `right` if level == 0 =>
            (y to i).toVector.filter(j => s(j) == right && (j == y || s(j - 1) != right)).flatMap {
              j => remove(s.substring(0, j) + s.substring(j + 1), left, right, i, j)
            }
          case _ => go(i + 1, level)
        }

      go(x, 0)
    }

    remove(s, '(', ')', 0, 0)
  }
}
