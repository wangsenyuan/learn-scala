package set0000.set600.set650.p659

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.isPossible(Array(1,2,3,3,4,5))
    res should be(true)
  }

  "example two" should "work" in {
    val res = Solution.isPossible(Array(1,2,3,3,4,4,5,5))
    res should be(true)
  }
}
