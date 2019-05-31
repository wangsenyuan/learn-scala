package set700.set720.p722

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.removeComments(Array(
      "void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"
    ))
    res should equal(List("void func(int k) {", "   k = k*2/4;", "   k = k/2;*/", "}"))
  }
}
