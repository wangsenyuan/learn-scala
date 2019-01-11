package set200.set210.p212

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val words = Array("oath", "pea", "eat", "rain")
    val board = Array(
      Array('o', 'a', 'a', 'n'),
      Array('e', 't', 'a', 'e'),
      Array('i', 'h', 'k', 'r'),
      Array('i', 'f', 'l', 'v'),
    )
    val res = Solution.findWords(board, words)

    val expect = Array("eat", "oath")

    res.sorted should equal(expect)
  }
}
