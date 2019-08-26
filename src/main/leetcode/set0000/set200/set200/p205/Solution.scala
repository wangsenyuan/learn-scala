package set0000.set200.set200.p205


object Solution {

  import scala.collection.mutable

  def isIsomorphic(s: String, t: String): Boolean = {
    val m = mutable.Map.empty[Char, Char]
    val r = mutable.Map.empty[Char, Char]
    var can = true
    var i = 0
    while (i < s.length && can) {
      val a = s(i)
      val b = t(i)

      if (m.contains(a) != r.contains(b)) {
        can = false
      } else if (m.contains(a)) {
        can = m(a) == b
      } else {
        m += a -> b
        r += b -> a
      }

      i += 1
    }

    can
  }
}
