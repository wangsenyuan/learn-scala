package set800.set850.p850

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val rects = Array(Array(0, 0, 1000000000, 1000000000))
    val res = Solution.rectangleArea(rects)
    res should be(49)
  }

  "example two" should "work" in {
    val rects = Array(Array(49, 40, 62, 100), Array(11, 83, 31, 99), Array(19, 39, 30, 99))
    val res = Solution.rectangleArea(rects)
    res should be(1584)
  }
}
