package set000.set020.p020

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "be true for string () to be valid" in {
    val res = Solution.isValid("()")
    res shouldBe true
  }

  it should "be true for string ()[]{} to be valid" in {
    val res = Solution.isValid("()[]{}")
    res shouldBe true
  }

  it should "be false for string ([)] to be valid" in {
    val res = Solution.isValid("([)]")
    res shouldBe false
  }

  it should "be true for string {[]} to be valid" in {
    val res = Solution.isValid("{[]}")
    res shouldBe true
  }
}
