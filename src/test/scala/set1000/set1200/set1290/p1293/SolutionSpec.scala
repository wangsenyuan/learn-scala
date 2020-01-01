package set1000.set1200.set1290.p1293

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val mat = Array(
      Array(0, 0, 0),
      Array(1, 1, 0),
      Array(0, 0, 0),
      Array(0, 1, 1),
      Array(0, 0, 0),
    )
    val res = Solution.shortestPath(mat, 1)
    res should be(6)
  }
}
