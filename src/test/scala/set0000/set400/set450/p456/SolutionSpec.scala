package set0000.set400.set450.p456

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.find132pattern(Array(-2, 1, 1))
    res should be(false)
  }
}
