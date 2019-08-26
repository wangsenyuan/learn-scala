package set0000.set700.set740.p748

object Solution {

  def countLetters(str: String) = {
    val cnt = Array.ofDim[Int](26)
    str.foreach(p => {
      if (p.isUpper) {
        cnt(p - 'A') += 1
      } else if (p.isLower) {
        cnt(p - 'a') += 1
      }
    })
    cnt
  }

  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
    val cnt = countLetters(licensePlate)

    var best = ""
    words.foreach(word => {
      if (best.length == 0 || best.length > word.length) {
        val tmp = countLetters(word)
        val can = tmp.zip(cnt).forall(x => x._1 >= x._2)
        if (can) {
          best = word
        }
      }
    })
    best
  }
}
