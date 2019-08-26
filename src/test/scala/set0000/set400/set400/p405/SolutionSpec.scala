package set0000.set400.set400.p405

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "-1" should "get ffffffff" in {
    val res = Solution.toHex(-1)
    res should be("ffffffff")
  }
}
