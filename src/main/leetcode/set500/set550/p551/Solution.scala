package set500.set550.p551

object Solution {
  def checkRecord(s: String): Boolean = {
    if (s.length < 2) {
      true
    } else {
      val absent = s.count(_ == 'A')
      val late = s.contains("LLL")

      absent <= 1 && !late
    }
  }
}
