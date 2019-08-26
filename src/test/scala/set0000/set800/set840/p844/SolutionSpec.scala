package set0000.set800.set840.p844

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val s = "ab#c"
    val t = "ad#c"
    val res = Solution.backspaceCompare(s, t)
    res should be(true)
  }

  "example two" should "work" in {
    val s = "ab##"
    val t = "c#d#"
    val res = Solution.backspaceCompare(s, t)
    res should be(true)
  }

  "example three" should "work" in {
    val s = "a##c"
    val t = "#a#c"
    val res = Solution.backspaceCompare(s, t)
    res should be(true)
  }

  "example four" should "work" in {
    val s = "a#c"
    val t = "b"
    val res = Solution.backspaceCompare(s, t)
    res should be(false)
  }


  "example five" should "work" in {
    val s = "xywrrmp"
    val t = "xywrrmu#p"
    val res = Solution.backspaceCompare(s, t)
    res should be(true)
  }

  "example six" should "work" in {
    val s = "bxj##tw"
    val t = "bxj###tw"
    val res = Solution.backspaceCompare(s, t)
    res should be(false)
  }
}
