package set600.set670.p675

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val forest = List(
      List(1,2,3),
      List(0,0,4),
      List(7,6,5),
    )
    val res = Solution.cutOffTree(forest)
    res should be(6)
  }
}
