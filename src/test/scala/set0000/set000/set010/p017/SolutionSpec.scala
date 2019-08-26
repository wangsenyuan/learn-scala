package set0000.set000.set010.p017

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get [\"ad\", \"ae\", \"af\", \"bd\", \"be\", \"bf\", \"cd\", \"ce\", \"cf\"] when input 23" in {
    val digits = "23"
    val res = Solution.letterCombinations(digits)
    val expect = List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").sorted
    res.sorted shouldBe expect
  }
}
