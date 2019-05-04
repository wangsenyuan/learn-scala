package set600.set600.p605

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
 "example one" should "work" in {
   val flowerbed = Array(1,0,0,0,0,1)
   val n = 2
   val res = Solution.canPlaceFlowers(flowerbed, n)
   res should be(false)
 }
}
