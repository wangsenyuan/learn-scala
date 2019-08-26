package set0000.set600.set600.p605

object Solution {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var m = 0
    var i = 0
    while (i < flowerbed.length) {
      if (flowerbed(i) == 0) {
        if(i == 0 || flowerbed(i-1) == 0) {
          if(i == flowerbed.length - 1 || flowerbed(i+1) == 0) {
            flowerbed(i) = 1
            m += 1
          }
        }
      }

      i += 1
    }
    m >= n
  }
}
