package set600.set630.p630

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val cs = Array(Array(100, 200), Array(200, 1300), Array(1000, 1250), Array(2000, 3200))
    val res = Solution.scheduleCourse(cs)
    res should be(3)
  }

  "example two" should "work" in {
    val cs = Array(Array(7,17), Array(3,12), Array(10,20), Array(9,10), Array(5,20), Array(10,19), Array(4,18))
    val res = Solution.scheduleCourse(cs)
    res should be(4)
  }
}
