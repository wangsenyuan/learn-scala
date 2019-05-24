package set600.set690.p691

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minStickers(Array("with", "example", "science"), "thehat")
    res should be(3)
  }
}
