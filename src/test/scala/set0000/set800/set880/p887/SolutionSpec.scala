package set0000.set800.set880.p887

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.superEggDrop(100, 10000)
    res should be(14)
  }

  "example two" should "work" in {
    val res = Solution.superEggDrop(2, 6)
    res should be(3)
  }

  "example three" should "work" in {
    val res = Solution.superEggDrop(2, 10)
    res should be(4)
  }
}
