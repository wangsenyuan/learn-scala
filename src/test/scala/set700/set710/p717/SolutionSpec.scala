package set700.set710.p717

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.isOneBitCharacter(Array(0, 1, 0))
    res should be(false)
  }
}
