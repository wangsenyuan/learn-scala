package set1000.set1300.set1330.p1334

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val n = 4
    val edges = Array(Array(0, 1, 3), Array(1, 2, 1), Array(1, 3, 4), Array(2, 3, 1))
    val distanceThreshold = 3
    val res = Solution.findTheCity(n, edges, distanceThreshold)
    res should be(0)
  }
}
