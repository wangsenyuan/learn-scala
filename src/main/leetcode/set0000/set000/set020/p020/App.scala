package set0000.set000.set020.p020

/**
  * Created by wangsenyuan on 7/1/16.
  */
object App extends App {

  private def pair(y: Char, x: Char): Boolean = {
    x match {
      case '(' => y == ')'
      case '{' => y == '}'
      case '[' => y == ']'
      case _ => false
    }
  }

  def isValid(str: String): Boolean = {
    def pairedIndex(i: Int, x: Char, level: Int): Int = {
      if (i >= str.size || (pair(str(i), x) && level == 1)) {
        i
      } else if (str(i) == x) {
        pairedIndex(i + 1, x, level + 1)
      } else if (pair(str(i), x)) {
        pairedIndex(i + 1, x, level - 1)
      } else {
        pairedIndex(i + 1, x, level)
      }
    }

    def go(i: Int): Boolean = {
      if (i >= str.length) {
        true
      } else {
        val j = pairedIndex(i + 1, str(i), 1)
        if (j == str.length) {
          false
        } else if (!isValid(str.substring(i + 1, j))) {
          false
        } else {
          go(j + 1)
        }
      }
    }
    go(0)
  }

  println(isValid("()[]{}"))
}
