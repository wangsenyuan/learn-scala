package set1000.set1300.set1350.p1353

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val events = Array(Array(1, 2), Array(1, 2), Array(3, 3), Array(1, 5), Array(1, 5))
    val res = Solution.maxEvents(events)
    res should be(5)
  }
}
