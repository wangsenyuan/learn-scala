package set0000.set500.set570.p576

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.findPaths(2, 2, 2, 0, 0)
    res should be(6)
  }

  "example two" should "work" in {
    val res = Solution.findPaths(2, 2, 1, 0, 0)
    res should be(2)
  }

  "example three" should "work" in {
    val res = Solution.findPaths(1, 3, 3, 0, 1)
    res should be(12)
  }
}
