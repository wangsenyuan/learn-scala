package set0000.set800.set860.p864

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array("@.a.#", "###.#", "b.A.B")
    val res = Solution.shortestPathAllKeys(grid)
    res should be(8)
  }

  "example two" should "work" in {
    val grid = Array("@..aA", "..B#.", "....b")
    val res = Solution.shortestPathAllKeys(grid)
    res should be(6)
  }

  "example three" should "work" in {
    val grid = Array("@...a", ".###A", "b.BCc")
    val res = Solution.shortestPathAllKeys(grid)
    res should be(10)
  }
}
