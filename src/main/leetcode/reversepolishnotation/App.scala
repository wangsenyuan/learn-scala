package reversepolishnotation

/**
 * Created by senyuanwang on 15/3/17.
 */
object App {

  val operators = Set("+", "-", "*", "/")

  def isOperator(c: String) = operators.contains(c)

  def operate(op: String, a: Int, b: Int) =
    op match {
      case "+" => a + b
      case "-" => a - b
      case "*" => a * b
      case "/" => a / b
      case _ => throw new IllegalArgumentException(op)
    }

  def evalRPN(tokens: Array[String]): Int = {
    val LEN = tokens.length
    def calc(index: Int, stack: List[Int]): Int =
      (index, stack) match {
        case (LEN, List(result)) => result
        case (i, list) =>
          (tokens(i), list) match {
            case (c, x :: y :: tail) if isOperator(c) =>
              calc(index + 1, operate(c, y, x) :: tail)
            case (c, _) => calc(index + 1, c.toInt :: list)
            case _ => throw new Exception(s"Bad case at $i")
          }
      }

    calc(0, Nil)
  }

  def main(args: Array[String]): Unit = {
    println(evalRPN(Array("2", "1", "+", "3", "*")))
    println(evalRPN(Array("4", "13", "5", "/", "+")))
  }
}
