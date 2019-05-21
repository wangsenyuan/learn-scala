package set600.set670.p678

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.checkValidString("()")
    res should be(true)
  }

  "example two" should "work" in {
    val res = Solution.checkValidString("(*)")
    res should be(true)
  }

  "example three" should "work" in {
    val res = Solution.checkValidString("(*))")
    res should be(true)
  }
}
