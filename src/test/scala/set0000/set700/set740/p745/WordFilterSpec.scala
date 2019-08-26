package set0000.set700.set740.p745

import org.scalatest.{FlatSpec, Matchers}

class WordFilterSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val wordFilter = new WordFilter(Array("apple"))
    wordFilter.f("a", "e") should be(0)
    wordFilter.f("b", "") should be(-1)
  }
}
