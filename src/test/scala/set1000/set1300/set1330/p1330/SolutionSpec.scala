package set1000.set1300.set1330.p1330

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.maxValueAfterReverse(Array(2, 3, 1, 5, 4))
    res should be(10)
  }
}
