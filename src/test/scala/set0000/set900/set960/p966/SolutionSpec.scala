package set0000.set900.set960.p966

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val words = Array("KiTe", "kite", "hare", "Hare")
    val queries = Array("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")
    val res = Solution.spellchecker(words, queries)
    res should be(Array("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"))
  }
}
