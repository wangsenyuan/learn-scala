package set800.set800.p803

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val grid = Array(Array(1,0,0,0),Array(1,1,1,0))
    val hits = Array(Array(1, 0))
    val res = Solution.hitBricks(grid, hits)
    res should equal(Array(2))
  }

  "example two" should "work" in {
    val grid = Array(Array(1,0,0,0),Array(1,1,0,0))
    val hits = Array(Array(1, 1), Array(1, 0))
    val res = Solution.hitBricks(grid, hits)
    res should equal(Array(0, 0))
  }
}
