package set0000.set400.set480.p488

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "WWRRBBWW and WRBRW" should "get 2" in {
    val res = Solution.findMinStep("WWRRBBWW","WRBRW")
    res should be(2)
  }

  "WRRBBW and RB" should "get -1" in {
    val res = Solution.findMinStep("WRRBBW","RB")
    res should be(-1)
  }

  "G and GGGGG" should "get 2" in {
    val res = Solution.findMinStep("G","GGGGG")
    res should be(2)
  }
}
