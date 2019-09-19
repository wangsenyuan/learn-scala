package set0000.set300.set380.p389

object Solution {
  def findTheDifference(s: String, t: String): Char = {
    val a = s.groupBy(identity).mapValues(_.size).toMap.withDefaultValue(0)
    val b = t.groupBy(identity).mapValues(_.size).toMap.withDefaultValue(0)
    var i = 0
    while (i < 26 && a(('a' + i).toChar) == b(('a' + i).toChar)) {
      i += 1
    }
    ('a' + i).toChar
  }
}
