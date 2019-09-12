package set0000.set900.set920.p925

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.isLongPressedName("vtkgn", "vttkgnn") should be(true)
  }
}
