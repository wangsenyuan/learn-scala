package set0000.set000.set000.p007

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 321 when reverse 123" in {
    val res = Solution.reverse(123)
    res shouldEqual 321
  }

  it should "get 21 when reverse 120" in {
    val res = Solution.reverse(120)
    res shouldEqual 21
  }

  it should "get -1 when reverse -1" in {
    val res = Solution.reverse(-1)
    res shouldEqual -1
  }

  it should "get 0 when reverse 1534236469" in {
    val res = Solution.reverse(1534236469)
    res shouldEqual 0
  }
}
