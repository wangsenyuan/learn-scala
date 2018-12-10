package set000.set050.p050

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 1024 when pow(2, 10)" in {
    val res = Solution.myPow(2, 10)
    ((res - 1024).abs < 1e-6) shouldBe true
  }

  it should "get 9.26100 when pow(2.1, 3)" in {
    val res = Solution.myPow(2.1, 3)
    ((res - 9.26100).abs < 1e-6) shouldBe true
  }

  it should "get 0.25 when pow(2, -2)" in {
    val res = Solution.myPow(2, -2)
    ((res - 0.25).abs < 1e-6) shouldBe true
  }

  it should "get 1 when pow(1, -2147483648)" in {
    val res = Solution.myPow(1, -2147483648)
    ((res - 1).abs < 1e-6) shouldBe true
  }

  it should "get 0 when pow(2, -2147483648)" in {
    val res = Solution.myPow(2, -2147483648)
    ((res - 0).abs < 1e-6) shouldBe true
  }
}
