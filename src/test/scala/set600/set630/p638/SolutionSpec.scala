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

  "example three" should "work" in {
    val prices = List(4, 10, 1, 5, 5, 3)
    val special = List(List(1, 2, 3, 3, 4, 1, 8), List(3, 4, 5, 5, 5, 2, 14), List(2, 4, 5, 1, 1, 3, 22))
    val need = List(1, 6, 5, 1, 1, 4)
    val res = Solution.shoppingOffers(prices, special, need)
    res should be(91)
  }

  "example four" should "work" in {
    val prices = List(3, 9, 10, 4, 7, 5)
    val special = List(List(6, 4, 1, 1, 2, 1, 2), List(5, 3, 1, 0, 0, 0, 34), List(5, 3, 6, 5, 3, 3, 35), List(3, 2, 0, 1, 3, 4, 12), List(0, 4, 5, 4, 0, 6, 17), List(2, 5, 5, 5, 0, 6, 28), List(0, 6, 1, 3, 3, 1, 34), List(4, 2, 3, 1, 2, 1, 28), List(6, 6, 0, 6, 1, 3, 1), List(1, 1, 5, 1, 4, 1, 29))
    val need = List(4, 0, 4, 4, 5, 5)
    val res = Solution.shoppingOffers(prices, special, need)
    res should be(128)
  }
}
