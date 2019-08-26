package set0000.set400.set420.p423

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "owoztneoer" should "get 012" in {
    val res = Solution.originalDigits("owoztneoer")
    res should be("012")
  }

  "zeroonetwothreefourfivesixseveneightnine" should "get 0123456789" in {
    val res = Solution.originalDigits("zeroonetwothreefourfivesixseveneightnine")
    res should be("0123456789")
  }
}
