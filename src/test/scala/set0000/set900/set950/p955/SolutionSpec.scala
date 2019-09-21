package set0000.set900.set950.p955

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array("ca", "bb", "ac")
    Solution.minDeletionSize(A) should be(1)
  }

  "example two" should "work" in {
    val A = Array("xc", "yb", "za")
    Solution.minDeletionSize(A) should be(0)
  }

  "example three" should "work" in {
    val A = Array("zyx", "wvu", "tsr")
    Solution.minDeletionSize(A) should be(3)
  }
}
