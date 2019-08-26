package set0000.set100.set180.p187

object Solution {
  def findRepeatedDnaSequences(s: String): List[String] = {
    if (s.length < 10) {
      Nil
    } else {
      var t = s.substring(0, 10)
      var cnt = Map.empty[String, Int]
      cnt += t -> 1

      var res = List.empty[String]
      var i = 10
      while (i < s.length) {
        t = t.tail + s(i)

        cnt.get(t) match {
          case None => cnt += t -> 1
          case Some(v) =>
            if (v == 1) {
              res = t :: res
            }
            cnt += t -> (v + 1)
        }

        i += 1
      }

      res
    }
  }
}
