package set0000.set900.set970.p975

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "10,13,12,14,15" should "get 2" in {
    val res = Solution.oddEvenJumps(Array(10, 13, 12, 14, 15))
    res should be(2)
  }

  "2,3,1,1,4" should "get 3" in {
    val res = Solution.oddEvenJumps(Array(2, 3, 1, 1, 4))
    res should be(3)
  }

  "5,1,3,4,2" should "get 3" in {
    val res = Solution.oddEvenJumps(Array(5, 1, 3, 4, 2))
    res should be(3)
  }

  "19, 56, 23, 96" should "get 3" in {
    val res = Solution.oddEvenJumps(Array(19, 56, 23, 96))
    res should be(3)
  }
}
