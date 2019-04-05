package set400.set490.p492

object Solution {
  def constructRectangle(area: Int): Array[Int] = {
    var sq = Math.sqrt(area).toInt
    while(sq > 1) {
      if(area % sq == 0) {
        return Array(area / sq, sq)
      }
      sq -= 1
    }
    return Array(area, 1)
  }
}
