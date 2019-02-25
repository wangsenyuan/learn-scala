package set300.set390.p391

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "get true" in {
    val rects = Array(Array(1,1,3,3),
      Array(3,1,4,2),
      Array(3,2,4,4),
      Array(1,3,2,4),
      Array(2,3,3,4),
    )
    val res = Solution.isRectangleCover(rects)
    res should be(true)
  }

  "example two" should "get false" in {
    val rects = Array(Array(1,1,3,3),
      Array(3,1,4,2),
      Array(3,2,4,4),
      Array(1,3,2,4),
      Array(2,2,4,4),
    )
    val res = Solution.isRectangleCover(rects)
    res should be(false)
  }
}
