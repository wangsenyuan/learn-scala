package set300.set380.p383

object Solution {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val cnt = Array.ofDim[Int](26)
    for {
      c <- magazine
    } {
      cnt(c - 'a') += 1
    }

    var i = 0
    while (i < ransomNote.length && cnt(ransomNote(i) - 'a') > 0) {
      cnt(ransomNote(i) - 'a') -= 1
      i += 1
    }
    i == ransomNote.length
  }
}
