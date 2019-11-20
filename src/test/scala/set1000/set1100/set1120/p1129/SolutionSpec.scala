package set1000.set1100.set1120.p1129

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val n = 3
    val red = Array(Array(0, 1), Array(1, 2))

    val res = Solution.shortestAlternatingPaths(n, red, Array())

    res should be(Array(0, 1, -1))
  }

  "example two" should "work" in {
    val n = 3
    val red = Array(Array(0, 1))
    val blue = Array(Array(2, 1))
    val res = Solution.shortestAlternatingPaths(n, red, blue)

    res should be(Array(0, 1, -1))
  }

  "example three" should "work" in {
    val n = 3
    val red = Array(Array(1, 0))
    val blue = Array(Array(2, 1))
    val res = Solution.shortestAlternatingPaths(n, red, blue)

    res should be(Array(0, -1, -1))
  }

  "example four" should "work" in {
    val n = 3
    val red = Array(Array(0, 1))
    val blue = Array(Array(1, 2))
    val res = Solution.shortestAlternatingPaths(n, red, blue)

    res should be(Array(0, 1, 2))
  }

  "example five" should "work" in {
    val n = 5
    val red = Array(Array(0, 1), Array(1, 2), Array(2, 3), Array(3, 4))
    val blue = Array(Array(1, 2), Array(2, 3), Array(3, 1))
    val res = Solution.shortestAlternatingPaths(n, red, blue)

    res should be(Array(0, 1, 2, 3, 7))
  }
}
