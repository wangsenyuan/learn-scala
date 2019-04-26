package set500.set580.p583

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec  extends FlatSpec with Matchers{
  "example one" should "work" in {
    val a = "sea"
    val b = "eat"
    val res = Solution.minDistance(a, b)
    res should be(2)
  }

  "example two" should "work" in {
    val a = "park"
    val b = "spake"
    val res = Solution.minDistance(a, b)
    res should be(3)
  }
}
