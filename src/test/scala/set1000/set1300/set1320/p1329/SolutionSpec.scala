package set1000.set1300.set1320.p1329

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val mat = Array(
      Array(3, 3, 1, 1), Array(2, 2, 1, 2), Array(1, 1, 1, 2)
    )
    Solution.diagonalSort(mat)

    val expect = Array(
      Array(1, 1, 1, 1), Array(1, 2, 2, 2), Array(1, 2, 3, 3)
    )

    mat should be(expect)
  }
}
