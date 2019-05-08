package set600.set630.p638

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val prices = List(2, 5)
    val special = List(List(3, 0, 5), List(1, 2, 10))
    val need = List(3, 2)
    val res = Solution.shoppingOffers(prices, special, need)
    res should be(14)
  }

  "example two" should "work" in {
    val prices = List(2, 3, 4)
    val special = List(List(1, 1, 0, 4), List(2, 2, 1, 9))
    val need = List(1, 2, 1)
    val res = Solution.shoppingOffers(prices, special, need)
    res should be(11)
  }
}
