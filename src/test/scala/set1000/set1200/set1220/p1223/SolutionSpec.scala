package set1000.set1200.set1220.p1223

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.dieSimulator(2, Array(1, 1, 2, 2, 2, 3))
    res should be(34)
  }

  "example two" should "work" in {
    val res = Solution.dieSimulator(2, Array(1, 1, 1, 1, 1, 1))
    res should be(30)
  }

  "example three" should "work" in {
    val res = Solution.dieSimulator(3, Array(1, 1, 1, 2, 2, 3))
    res should be(181)
  }
}
