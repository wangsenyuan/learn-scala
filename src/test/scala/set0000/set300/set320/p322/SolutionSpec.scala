package set0000.set300.set320.p322

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1, 2, 5] and 11" should "get 3" in {
    val res = Solution.coinChange(Array(1, 2, 5), 11)
    res should be(3)
  }

  "[2] and 3" should "get -1" in {
    val res = Solution.coinChange(Array(2), 3)
    res should be(-1)
  }

  "[186,419,83,408] and 6249" should "get 20" in {
    val res = Solution.coinChange(Array(186, 419, 83, 408), 6249)
    res should be(20)
  }

  "[125,146,125,252,226,25,24,308,50] and 8402" should "get 29" in {
    val res = Solution.coinChange(Array(125, 146, 125, 252, 226, 25, 24, 308, 50), 8402)
    res should be(29)
  }
}
