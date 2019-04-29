package set600.set600.p600

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.findIntegers(5)
    res should be(5)
  }

  "example two" should "work" in {
    val res = Solution.findIntegers(100)
    res should be(34)
  }

  "example three" should "work" in {
    val res = Solution.findIntegers(19)
    res should be(11)
  }
}
