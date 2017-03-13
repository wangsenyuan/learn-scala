package codechef.easy.bex

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/03/2017.
  */
object Main {

  case class Book(name: String, remainingExercise: Int, top: Int)

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()

    val stack = Array.fill[Book](n)(null)
    var p = 0

    while (n > 0) {
      val line = StdIn.readLine()
      if (line == "-1") {
        val book = stack(p - 1)
        p -= 1
        println(s"${book.top} ${book.name}")
      } else {
        val strs = line.split("\\s+")
        val remaining = strs(0).toInt
        if (remaining > 0) {
          val name = strs(1)
          if (p == 0 || remaining <= stack(p - 1).remainingExercise) {
            stack(p) = Book(name, remaining, 0)
            p += 1
          } else {
            val book = stack(p - 1)
            stack(p - 1) = book.copy(top = book.top + 1)
          }
        }
      }

      n -= 1
    }
  }
}
