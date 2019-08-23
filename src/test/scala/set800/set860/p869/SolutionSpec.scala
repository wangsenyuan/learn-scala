package set800.set860.p869

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.reorderedPowerOf2(1) should be(true)
  }

  "example two" should "work" in {
    Solution.reorderedPowerOf2(10) should be(false)
  }

  "example three" should "work" in {
    Solution.reorderedPowerOf2(46) should be(true)
  }
}
