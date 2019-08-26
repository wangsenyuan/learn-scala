package set0000.set000.set030.p037

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  object example1 {
    val input =
      """
        |[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
      """.stripMargin.trim

    def output =
      """
        |[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
      """.stripMargin.trim
  }

  def strToArray(str: String): Array[Array[Char]] = {
    val s1 = str.substring(2, str.length - 2)
    val ss = s1.split("\\],\\[")
    val res = Array.fill[Array[Char]](9)(null)
    var i = 0
    while (i < 9) {
      val s = ss(i)
      val x = s.split(",")
      res(i) = x.map(_.charAt(1))
      i += 1
    }
    res
  }

  def arrayToStr(arr: Array[Array[Char]]): String = {
    "[[" + (arr.map(row => row.map(c => "\"" + c + "\"").mkString(",")).mkString("],[")) + "]]"
  }

  it should "work with example1" in {
    val arr = strToArray(example1.input)
    Solution.solveSudoku(arr)
    //    println(example1.output)
    arrayToStr(arr) shouldEqual example1.output
  }
}
