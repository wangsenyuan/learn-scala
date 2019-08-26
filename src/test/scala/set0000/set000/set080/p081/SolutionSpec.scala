package set0000.set000.set080.p081

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "2,5,6,0,0,1,2" should "find 0 success" in {
    val res = Solution.search(Array(2, 5, 6, 0, 0, 1, 2), 0)
    res should be(true)
  }

  it should "find 3 fail" in {
    val res = Solution.search(Array(2, 5, 6, 0, 0, 1, 2), 3)
    res should be(false)
  }

  "1, 1, 3, 1" should "find 3 success" in {
    val res = Solution.search(Array(1, 1, 3, 1), 3)
    res should be(true)
  }
}
