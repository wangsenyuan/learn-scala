package set0000.set800.set880.p880

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.decodeAtIndex("ha22", 5)
    res should be("h")
  }

  "example two" should "work" in {
    val res = Solution.decodeAtIndex("a2345678999999999999999", 5)
    res should be("a")
  }

  "example three" should "work" in {
    val res = Solution.decodeAtIndex("a23", 6)
    res should be("a")
  }

  "example four" should "work" in {
    val res = Solution.decodeAtIndex("a2b3c4d5e6f7g8h9", 9)
    res should be("b")
  }

  "example five" should "work" in {
    val res = Solution.decodeAtIndex("vk6u5xhq9v", 554)
    res should be("k")
  }

  "example six" should "work" in {
    val res = Solution.decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153)
    res should be("a")
  }
}
