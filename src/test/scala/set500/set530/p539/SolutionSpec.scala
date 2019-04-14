package set500.set530.p539

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val times = List("23:59","00:00")
    val res = Solution.findMinDifference(times)
    res should be(1)
  }
}
