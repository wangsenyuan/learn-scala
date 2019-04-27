package set500.set590.p591

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val str = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
    val res = Solution.isValid(str)
    res should be(true)
  }

  "example two" should "work" in {
    val str = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
    val res = Solution.isValid(str)
    res should be(true)
  }

  "example three" should "work" in {
    val str = "<A>  <B> </A>   </B>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example four" should "work" in {
    val str = "<DIV>  div tag is not closed  <DIV>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example five" should "work" in {
    val str = "<DIV>  unmatched <  </DIV>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example six" should "work" in {
    val str = "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example seven" should "work" in {
    val str = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example eight" should "work" in {
    val str = "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example nine" should "work" in {
    val str = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example ten" should "work" in {
    val str = "<TRUe><![CDATA[123123]]]]><![CDATA[>123123]]></TRUe>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example eleven" should "work" in {
    val str = "<AAAAAAAAAA></AAAAAAAAAA>"
    val res = Solution.isValid(str)
    res should be(false)
  }

  "example twelve" should "work" in {
    val str = "<A><A></A></A>"
    val res = Solution.isValid(str)
    res should be(true)
  }

  "example thirty" should "work" in {
    val str = "<A></A>"
    val res = Solution.isValid(str)
    res should be(true)
  }
}
