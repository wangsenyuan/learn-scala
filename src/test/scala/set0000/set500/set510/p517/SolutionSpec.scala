package set0000.set500.set510.p517

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 2" in {
    val ms = Array(4, 0, 0, 4)
    val res = Solution.findMinMoves(ms)
    res should be(2)
  }

  "example two" should "get 3" in {
    val ms = Array(1, 0, 5)
    val res = Solution.findMinMoves(ms)
    res should be(3)
  }


  "example three" should "get 2" in {
    val ms = Array(0, 3, 0)
    val res = Solution.findMinMoves(ms)
    res should be(2)
  }

  "example four" should "get 8" in {
    val ms = Array(0, 0, 11, 5)
    val res = Solution.findMinMoves(ms)
    res should be(8)
  }

  "example five" should "get 4" in {
    val ms = Array(9, 1, 8, 8, 9)
    val res = Solution.findMinMoves(ms)
    res should be(4)
  }
}
