package set0000.set700.set760.p768

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.maxChunksToSorted(Array(5,4,3,2,1))
    res should be(1)
  }

  "example two" should "work" in {
    val res = Solution.maxChunksToSorted(Array(2,1,3,4,4))
    res should be(4)
  }

  "example three" should "work" in {
    val res = Solution.maxChunksToSorted(Array(1,2,3,4,4))
    res should be(5)
  }
}
