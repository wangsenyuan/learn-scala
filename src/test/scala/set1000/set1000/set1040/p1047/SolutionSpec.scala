package set1000.set1000.set1040.p1047

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.removeDuplicates("abbaca")
    res should be("ca")
  }
}
