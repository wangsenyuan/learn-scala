package set0000.set400.set440.p447

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example two" should "work" in {
    val points = Array(Array(1, 1), Array(2, 2), Array(3, 3))
    val res = Solution.numberOfBoomerangs(points)
    res should be(2)
  }
}
