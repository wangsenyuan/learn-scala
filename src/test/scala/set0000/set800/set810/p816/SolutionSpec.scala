package set0000.set800.set810.p816

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val s = "(123)"
    val res = Solution.ambiguousCoordinates(s)
    res.sorted should be(List("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)").sorted)
  }

  "example two" should "work" in {
    val s = "(00011)"
    val res = Solution.ambiguousCoordinates(s)
    res.sorted should be(List("(0.001, 1)", "(0, 0.011)").sorted)
  }

  "example three" should "work" in {
    val s = "(0123)"
    val res = Solution.ambiguousCoordinates(s)
    res.sorted should be(List("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)").sorted)
  }

  "example four" should "work" in {
    val s = "(100)"
    val res = Solution.ambiguousCoordinates(s)
    res.sorted should be(List("(10, 0)").sorted)
  }
}
