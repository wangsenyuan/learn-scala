package set700.set780.p787

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val n = 3
    val flights = Array(Array(0,1,100),Array(1,2,100),Array(0,2,500))
    val src = 0
    val dst = 2
    val k = 1
    val res = Solution.findCheapestPrice(n, flights, src, dst, k)
    res should be(200)
  }

  "example two" should "work" in {
    val n = 3
    val flights = Array(Array(0,1,100),Array(1,2,100),Array(0,2,500))
    val src = 0
    val dst = 2
    val k = 0
    val res = Solution.findCheapestPrice(n, flights, src, dst, k)
    res should be(500)
  }
}
