package set0000.set900.set980.p989

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array(3, 9, 7, 6, 9, 5, 3, 4, 4, 9)
    val res = Solution.addToArrayForm(A, 982)
    res should be(Array(3, 9, 7, 6, 9, 5, 4, 4, 3, 1))
  }
}
