package set0000.set400.set490.p495

object Solution {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    var positionEnd = 0
    var ans = 0
    for {
      i <- timeSeries.indices
    } {
      ans += timeSeries(i) + duration - (timeSeries(i) max positionEnd)
      positionEnd = timeSeries(i) + duration
    }

    ans
  }
}
