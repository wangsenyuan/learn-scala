package set0000.set900.set900.p903

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numPermsDISequence("DID")
    res should be(5)
  }

  "example two" should "work" in {
    val res = Solution.numPermsDISequence("IDDDIIDIIIIIIIIDIDID")
    res should be(853197538)
  }

  // "IIDIIDDIDDDDIIDDIDIDIDDDDIDDDIIIIDDIDDDDIDIIDDIDID"

  "example three" should "work" in {
    val res = Solution.numPermsDISequence("IIDIIDDIDDDDIIDDIDIDIDDDDIDDDIIIIDDIDDDDIDIIDDIDID")
    res should be(997381513)
  }

  "example four" should "work" in {
    val res = Solution.numPermsDISequence("IIIIIIIIII")
    res should be(1)
  }
}
