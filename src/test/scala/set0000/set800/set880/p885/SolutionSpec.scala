package set0000.set800.set880.p885

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.spiralMatrixIII(1, 4, 0, 0)
    val expect = Array(Array(0, 0), Array(0, 1), Array(0, 2), Array(0, 3))
    res should equal(expect)
  }

  "example two" should "work" in {
    val res = Solution.spiralMatrixIII(5, 6, 1, 4)
    val expect = Array(Array(1, 4), Array(1, 5), Array(2, 5), Array(2, 4), Array(2, 3), Array(1, 3), Array(0, 3), Array(0, 4), Array(0, 5), Array(3, 5), Array(3, 4), Array(3, 3), Array(3, 2), Array(2, 2), Array(1, 2), Array(0, 2), Array(4, 5), Array(4, 4), Array(4, 3), Array(4, 2), Array(4, 1), Array(3, 1), Array(2, 1), Array(1, 1), Array(0, 1), Array(4, 0), Array(3, 0), Array(2, 0), Array(1, 0), Array(0, 0))
    res should equal(expect)
  }
}
