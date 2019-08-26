package set0000.set200.set220.p223

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 45" in {
    val A = -3
    val B = 0
    val C = 3
    val D = 4
    val E = 0
    val F = -1
    val G = 9
    val H = 2
    val res = Solution.computeArea(A, B, C, D, E, F, G, H)
    res should be(45)
  }
}
