package set000.set080.p085

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[  [\"1\",\"0\",\"1\",\"0\",\"0\"],  [\"1\",\"0\",\"1\",\"1\",\"1\"],  [\"1\",\"1\",\"1\",\"1\",\"1\"],  [\"1\",\"0\",\"0\",\"1\",\"0\"]]" should "get 6" in {
    val mat = Array(
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0'),
    )
    Solution.maximalRectangle(mat) should be(6)
  }

  "[[\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\"]]" should "get 12" in {
    val mat = Array(
      Array('1', '1', '1', '1'),
      Array('1', '1', '1', '1'),
      Array('1', '1', '1', '1'),
    )
    Solution.maximalRectangle(mat) should be(12)
  }
  "[[\"0\",\"1\"]]" should "get 1" in {
    val mat = Array(
      Array('0', '1'),
    )
    Solution.maximalRectangle(mat) should be(1)
  }
}
