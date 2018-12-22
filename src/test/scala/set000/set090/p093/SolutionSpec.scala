package set000.set090.p093

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "25525511135" should "get [\"255.255.11.135\", \"255.255.111.35\"]" in {
    val s = "25525511135"
    val res = Solution.restoreIpAddresses(s)

    res.sorted should equal(List("255.255.11.135", "255.255.111.35").sorted)
  }
}
