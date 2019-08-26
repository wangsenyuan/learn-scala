package set0000.set600.set690.p695

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val grid = Array(Array(1,1,0,0,0), Array(1,1,0,0,0),Array(0,0,0,1,1),Array(0,0,0,1,1))
    val res = Solution.maxAreaOfIsland(grid)
    res should be(4)
  }

  "example two" should "work" in {
    val grid = Array(Array(1,1,0,1,1), Array(1,0,0,0,0),Array(0,0,0,0,1),Array(1,1,0,1,1))
    val res = Solution.maxAreaOfIsland(grid)
    res should be(3)
  }
}
