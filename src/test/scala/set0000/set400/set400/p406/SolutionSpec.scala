package set0000.set400.set400.p406

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]" should "get [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]" in {
    val arr = Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))
    val res = Solution.reconstructQueue(arr)
    res should be(Array(Array(5, 0), Array(7, 0), Array(5, 2), Array(6, 1), Array(4, 4), Array(7, 1)))
  }
}
