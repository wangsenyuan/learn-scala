package set0000.set200.set240.p242

object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    val cnt = Array.fill(26)(0)
    s.foreach(x => cnt(x - 'a') += 1)
    t.foreach(x => cnt(x - 'a') -= 1)

    cnt.forall(_ == 0)
  }
}
