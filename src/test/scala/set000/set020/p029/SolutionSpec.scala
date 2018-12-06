package set000.set020.p029

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 3 when 10 / 3" in {
    val res = Solution.divide(10, 3)
    res shouldBe 3
  }

  it should "get 2147483647 when -2147483648 / -1" in {
    val res = Solution.divide(-2147483648, -1)
    res shouldBe 2147483647
  }
}
