package set700.set740.p744

object Solution {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    val n = letters.length
    var left = 0
    var right = n
    while(left < right) {
      val mid = (left + right) >> 1
      if(letters(mid) > target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    letters(right % n)
  }
}
