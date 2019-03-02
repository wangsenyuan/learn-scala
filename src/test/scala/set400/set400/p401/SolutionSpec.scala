package set400.set400.p401

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "1" should "work" in {
    val res = Solution.readBinaryWatch(1)
    val expect = List("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32").sorted
    res.sorted should equal(expect)
  }

  "0" should "work" in {
    val res = Solution.readBinaryWatch(0)
    res should equal(List("0:00"))
  }
}
