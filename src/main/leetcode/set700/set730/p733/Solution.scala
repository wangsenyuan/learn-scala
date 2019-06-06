package set700.set730.p733

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    if (image.length > 0 && image(0).length > 0) {
      if (image(sr)(sc) != newColor) {
        val oldColor = image(sr)(sc)

        image(sr)(sc) = newColor
        val m = image.length
        val n = image(0).length

        val que = Array.ofDim[Int](m * n)
        var front = 0
        var end = 0
        que(end) = sr * n + sc
        end += 1
        while (front < end) {
          val cur = que(front)
          front += 1
          val x = cur / n
          val y = cur % n
          var k = 0
          while (k < 4) {
            val u = x + dd(k)
            val v = y + dd(k + 1)

            if (u >= 0 && u < m && v >= 0 && v < n && image(u)(v) == oldColor) {
              image(u)(v) = newColor
              que(end) = u * n + v
              end += 1
            }

            k += 1
          }
        }
      }
    }

    image
  }
}
