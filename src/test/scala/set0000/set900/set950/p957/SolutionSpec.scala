package set0000.set900.set950.p957

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val cells = Array(0, 1, 0, 1, 1, 0, 0, 1)
    val res = Solution.prisonAfterNDays(cells, 7)
    res should be(Array(0, 0, 1, 1, 0, 0, 0, 0))
  }

  "example two" should "work" in {
    val cells = Array(1, 0, 0, 1, 0, 0, 1, 0)
    val res = Solution.prisonAfterNDays(cells, 1000000000)
    res should be(Array(0, 0, 1, 1, 1, 1, 1, 0))
  }
}
