package set0000.set700.set780.p781

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val ans = Array(1, 1, 0, 0, 0)
    val res = Solution.numRabbits(ans)
    res should be(5)
  }

  "example two" should "work" in {
    val ans = Array(10, 10, 10)
    val res = Solution.numRabbits(ans)
    res should be(11)
  }

  "example three" should "work" in {
    val ans = Array(1, 1, 2)
    val res = Solution.numRabbits(ans)
    res should be(5)
  }

  "example four" should "work" in {
    val ans = Array(1, 1, 0, 0, 1)
    val res = Solution.numRabbits(ans)
    res should be(6)
  }
}
