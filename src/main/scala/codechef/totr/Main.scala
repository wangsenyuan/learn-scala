package codechef.totr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line0 = StdIn.readLine().split("\\s+")
    var t = line0(0).toInt
    val m = line0(1)

    val letters = "abcdefghijklmnopqrstuvwxyz"
    val mapping = letters.zip(m).flatMap {
      case (a, b) =>
        List(a -> b, a.toUpper -> b.toUpper)
    } toMap

    while (t > 0) {
      t -= 1
      val line = StdIn.readLine()
      val translation = line.map {
        case '_' => ' '
        case letter if (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z') => mapping(letter)
        case a => a
      }

      println(translation)
    }
  }
}
