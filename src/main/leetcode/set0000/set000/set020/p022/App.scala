package set0000.set000.set020.p022

import scala.collection.mutable.ListBuffer

/**
  * Created by senyuanwang on 16/7/2.
  */
object App extends App {

  def generateParenthesis(n: Int): List[String] = {
    def go(toOpen: Int, toClose: Int, path: String, res: ListBuffer[String]): Unit = {
      if (path.length == 2 * n) {
        res += path
      } else {
        if (toOpen > 0) {
          go(toOpen - 1, toClose + 1, path + "(", res)
        }
        if (toClose > 0) {
          go(toOpen, toClose - 1, path + ")", res)
        }
      }
    }

    val res = ListBuffer.empty[String]

    go(n, 0, "", res)

    res.toList
  }

  generateParenthesis(4).foreach(println)
}
