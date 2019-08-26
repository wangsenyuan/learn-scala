package set0000.set800.set850.p853

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val target = 12
    val position = Array(10, 8, 0, 5, 3)
    val speed = Array(2, 4, 1, 1, 3)
    val res = Solution.carFleet(target, position, speed)
    res should be(3)
  }

  "example two" should "work" in {
    val target = 10
    val position = Array(0, 4, 2)
    val speed = Array(2, 1, 3)
    val res = Solution.carFleet(target, position, speed)
    res should be(1)
  }
}
