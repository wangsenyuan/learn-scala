package set0000.set500.set540.p546

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1, 3, 2, 2, 2, 3, 4, 3, 1]" should "get 23" in {
    val res = Solution.removeBoxes(Array(1, 3, 2, 2, 2, 3, 4, 3, 1))
    res should be(23)
  }
}
