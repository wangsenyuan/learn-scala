package set0000.set900.set990.p995

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minKBitFlips(Array(0, 1, 0), 1)
    res should be(2)
  }

  "example two" should "work" in {
    val res = Solution.minKBitFlips(Array(1, 1, 0), 2)
    res should be(-1)
  }

  "example three" should "work" in {
    val res = Solution.minKBitFlips(Array(0, 0, 0, 1, 0, 1, 1, 0), 3)
    res should be(3)
  }
}
