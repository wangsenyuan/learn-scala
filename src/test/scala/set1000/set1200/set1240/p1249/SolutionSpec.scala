package set1000.set1200.set1240.p1249

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val str = "())()((("
    val res = Solution.minRemoveToMakeValid(str)
    res should be("()()")
  }
}
