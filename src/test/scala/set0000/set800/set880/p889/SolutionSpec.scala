package set0000.set800.set880.p889

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val res = Solution.constructFromPrePost(Array(1, 2, 4, 5, 3, 6, 7), Array(4, 5, 2, 6, 7, 3, 1))
    res should not be (null)
  }
}
