package set000.set060.p068

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  """
    |"This", "is", "an", "example", "of", "text", "justification."
  """.stripMargin should
    """
      |"This    is    an",
      |"example  of text",
      |"justification.  "
    """.stripMargin in {
    val words = Array("This", "is", "an", "example", "of", "text", "justification.")
    val res = Solution.fullJustify(words, 16)
    res shouldEqual List("This    is    an", "example  of text", "justification.  ")
  }

  """
    |"What","must","be","acknowledgment","shall","be"
  """.stripMargin should
    """
      | "What   must   be",
      | "acknowledgment  ",
      | "shall be        "
    """.stripMargin in {
    val words = Array("What", "must", "be", "acknowledgment", "shall", "be")
    val res = Solution.fullJustify(words, 16)
    res shouldEqual List("What   must   be", "acknowledgment  ", "shall be        ")
  }

  """
    |"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
  """.stripMargin should
    """
      |"Science  is  what we",
      |"understand      well",
      |"enough to explain to",
      |"a  computer.  Art is",
      |"everything  else  we",
      |"do                  "
    """.stripMargin in {
    val words = Array("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do")
    val res = Solution.fullJustify(words, 20)
    res shouldEqual List("Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  ")
  }
}
