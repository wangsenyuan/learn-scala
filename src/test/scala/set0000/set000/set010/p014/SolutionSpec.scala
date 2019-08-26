package set0000.set000.set010.p014

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get fl in [\"flower\",\"flow\",\"flight\"]" in {
    val res = Solution.longestCommonPrefix(Array("flower", "flow", "flight"))
    res shouldBe "fl"
  }
}
