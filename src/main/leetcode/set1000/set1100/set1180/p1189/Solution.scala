package set1000.set1100.set1180.p1189

object Solution {
  def maxNumberOfBalloons(text: String): Int = {
    //balloon
    val cnts = Array.ofDim[Int](26)
    text.foreach(c => cnts(c - 'a') += 1)
    var ans = cnts(1)
    ans = ans min (cnts(0))
    ans = ans min (cnts('l' - 'a') / 2)
    ans = ans min (cnts('o' - 'a') / 2)
    ans = ans min cnts('n' - 'a')
    ans
  }
}
