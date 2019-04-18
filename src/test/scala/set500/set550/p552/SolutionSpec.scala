package set500.set550.p552

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "10" should "get 3536" in {
    val res = Solution.checkRecord(10)
    res should be(3536)
  }

  "4" should "get 43" in {
    val res = Solution.checkRecord(4)
    res should be(43)
  }
}
