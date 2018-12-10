package set000.set040.p049

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val g = strs.groupBy(anagram)
    g.values.map(_.toList).toList
  }

  private def anagram(str: String): String = {
    val cs = str.toCharArray
    cs.sorted.mkString("")
  }
}
