package set0000.set900.set970.p972

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.isRationalEqual("0.(52)", "0.5(25)")
    res should be(true)
  }
}
