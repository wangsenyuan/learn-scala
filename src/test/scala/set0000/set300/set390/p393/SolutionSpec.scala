package set0000.set300.set390.p393

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[197, 130, 1]" should "be valid utf-8 encoded" in {
    val res = Solution.validUtf8(Array(197, 130, 1))
    res should be(true)
  }

  "[235, 140, 4]" should "not be valid utf-8 encoded" in {
    val res = Solution.validUtf8(Array(235, 140, 4))
    res should be(false)
  }
}
