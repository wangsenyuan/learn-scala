package set700.set750.p754

object Solution {
  def reachNumber(target: Int): Int = {
    var delta = target.abs
    var k = 0
    while(delta > 0) {
      k += 1
      delta -= k
    }

    if(delta % 2 == 0) {
      k
    } else {
      k + 1 + k % 2
    }
  }
}
