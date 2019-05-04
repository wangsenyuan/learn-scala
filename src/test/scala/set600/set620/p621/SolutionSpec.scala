package set600.set620.p621

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec  extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.leastInterval("AAABBB".toCharArray, 2)
    res should be(8)
  }
}
