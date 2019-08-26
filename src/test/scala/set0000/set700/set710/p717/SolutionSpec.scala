package set0000.set700.set710.p717

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.isOneBitCharacter(Array(0, 1, 0))
    res should be(false)
  }

  "example two" should "work" in {
    val res = Solution.isOneBitCharacter(Array(1,0,0))
    res should be(true)
  }

  "example three" should "work" in {
    val res = Solution.isOneBitCharacter(Array(0,0))
    res should be(true)
  }
}
