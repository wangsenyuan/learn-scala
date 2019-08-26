package set0000.set600.set630.p634

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.exclusiveTime(1, List(
      "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))
    res should equal(Array(8))
  }
}
