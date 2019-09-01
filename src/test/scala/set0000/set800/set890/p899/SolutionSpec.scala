package set0000.set800.set890.p899

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val ans = Solution.orderlyQueue("cba", 1)
    ans should be("acb")
  }

  "example two" should "work" in {
    val ans = Solution.orderlyQueue("baaca", 3)
    ans should be("aaabc")
  }
}
