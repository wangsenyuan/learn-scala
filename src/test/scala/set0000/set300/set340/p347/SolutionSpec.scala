package set0000.set300.set340.p347

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,1,1,2,2,3] and 2" should "get [1, 2]" in {
    val res = Solution.topKFrequent(Array(1, 1, 1, 2, 2, 3), 2)
    res.sorted should equal(List(1, 2))
  }
}
