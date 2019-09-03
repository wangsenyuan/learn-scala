package set0000.set900.set900.p904

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.totalFruit(Array(0, 1, 1, 4, 3))
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.totalFruit(Array(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4))
    res should be(5)
  }

  "example three" should "work" in {
    val res = Solution.totalFruit(Array(0, 1, 6, 6, 4, 4, 6))
    res should be(5)
  }
}
