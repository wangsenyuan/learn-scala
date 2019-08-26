package set0000.set300.set390.p399

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val equations = Array(Array("a", "b"), Array("b", "c"))
    val vs = Array(2.0, 3.0)
    val queries = Array(Array("a", "c"), Array("b", "a"), Array("a", "e"), Array("a", "a"), Array("x", "x"))
    val res = Solution.calcEquation(equations, vs, queries)
    res should equal(Array(6.0, 0.5, -1.0, 1.0, -1.0))
  }
}
